package com.proyecto.entrega2.controller;

import com.proyecto.entrega2.entity.Juego;
import com.proyecto.entrega2.service.JuegoService;
import com.proyecto.entrega2.entity.estadoJuego;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {
    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping
    public ResponseEntity<Juego> createZone(@RequestBody Juego juego){
        return ResponseEntity.status(HttpStatus.CREATED).body(juegoService.createJuego(juego));
    }

    @GetMapping
    public List<Juego> getAllJuegos(){
        return juegoService.getAllJuegos();
    }

    @GetMapping("/{id}")
    public Juego getZoneById(@PathVariable Long id){
        return juegoService.getJuegoById(id);
    }
    @GetMapping("/filtrarEstado/{estado}")
    public List<Juego> getJuegosByEstado(@PathVariable String estado){
        estadoJuego estadoenum=estadoJuego.valueOf(estado.toUpperCase()) ;
        return juegoService.getJuegosByEstado(estadoenum);
    }
    @GetMapping("/buscarTitulo/{titulo}")
    public Juego getJuegoByTitulo(@PathVariable String titulo){
        return juegoService.getJuegoByTitulo(titulo);
    }
    @GetMapping("/filtrarPlataforma/{plataforma}")
    public List<Juego> getJuegosByPlataforma(@PathVariable String plataforma){
        return juegoService.getJuegosByPlataforma(plataforma);
    }

    @PutMapping("/{id}")
    public Juego updateZone(@PathVariable Long id, @RequestBody Juego updatedJuego){
        return juegoService.updateJuego(id, updatedJuego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable Long id){
        juegoService.deleteJuego(id);
        return ResponseEntity.noContent().build();
    }
}
