package com.proyecto.entrega2.controller;

import com.proyecto.entrega2.dto.AuthResponse;
import com.proyecto.entrega2.dto.LoginRequest;
import com.proyecto.entrega2.dto.RegisterRequest;
import com.proyecto.entrega2.entity.User;
import com.proyecto.entrega2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.getUserByEmail(request.getEmail());

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = "token-" + user.getId() + "-" + System.currentTimeMillis();
                user.setPassword(null);

                AuthResponse response = new AuthResponse(token, user);
                return ResponseEntity.ok(response);
            }

            return ResponseEntity.status(401).body("Contraseña incorrecta");
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            // Validaciones
            if (request.getName() == null || request.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("El nombre es obligatorio");
            }

            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("El email es obligatorio");
            }

            if (request.getPassword() == null || request.getPassword().length() < 6) {
                return ResponseEntity.badRequest().body("La contraseña debe tener al menos 6 caracteres");
            }

            if (request.getAge() < 1 || request.getAge() > 120) {
                return ResponseEntity.badRequest().body("Edad inválida");
            }

            if (request.getSex() == null) {
                return ResponseEntity.badRequest().body("El sexo es obligatorio");
            }

            // Crear nuevo usuario
            User newUser = new User();
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setAge(request.getAge());
            newUser.setSex(request.getSex());

            // Guardar en base de datos
            User savedUser = userService.createUser(newUser);
            savedUser.setPassword(null);

            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}