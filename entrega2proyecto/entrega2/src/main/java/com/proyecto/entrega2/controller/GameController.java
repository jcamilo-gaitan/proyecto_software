package com.proyecto.entrega2.controller;

import com.proyecto.entrega2.entity.Game;
import com.proyecto.entrega2.entity.gameStatus;
import com.proyecto.entrega2.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game game){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.createGame(game));
    }

    @GetMapping
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id){
        return gameService.getGameById(id);
    }

    @GetMapping("/buscarTitulo/{titulo}")
    public Game getGameByTitle(@PathVariable String titulo){
        return gameService.getGamesByTitle(titulo);
    }
    @GetMapping("/filtrarPlataforma/{plataforma}")
    public List<Game> getGamesByPlatform(@PathVariable String plataforma){
        return gameService.getGamesByPlatform(plataforma);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game updatedGame){
        return gameService.updateGame(id, updatedGame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
