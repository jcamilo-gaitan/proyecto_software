package com.proyecto.entrega2.service;
import com.proyecto.entrega2.entity.*;
import com.proyecto.entrega2.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User usuario) {

        return userRepository.save(usuario);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public User updateUser(Long id, User updatedUsuario) {
        User usuario= getUserById(id);
        usuario.setName(updatedUsuario.getName());
        usuario.setEmail(updatedUsuario.getEmail());
        usuario.setPassword(updatedUsuario.getPassword());
        usuario.setAge(updatedUsuario.getAge());
        usuario.setSex(updatedUsuario.getSex());
        if(!(usuario.getSex().equalsIgnoreCase("MASCULINO") || usuario.getSex().equalsIgnoreCase("FEMENINO")) ){
            throw new ValueOutOfRangeException("El título puede tener maximo 336 caracteres");
        }
        if(usuario.getAge()>122){
            throw new ValueOutOfRangeException("La edad no puede ser superior a 122");
        }

        return userRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        User usuario= getUserById(id);

        userRepository.delete(usuario);

    }
}
