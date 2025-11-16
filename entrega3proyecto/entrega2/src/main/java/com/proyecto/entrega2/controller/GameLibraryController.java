package com.proyecto.entrega2.controller;

import com.proyecto.entrega2.dto.GameLibraryDTO;
import com.proyecto.entrega2.entity.GameLibrary;
import com.proyecto.entrega2.entity.Game;
import com.proyecto.entrega2.entity.gameStatus;
import com.proyecto.entrega2.service.GameLibraryService;

import com.proyecto.entrega2.service.GameService;
import com.proyecto.entrega2.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/biblioteca")
public class GameLibraryController
{
    private final GameLibraryService gameLibraryService;
    private final GameService gameService;
    private final UserService userService;
    public  GameLibraryController(GameLibraryService gameLibraryService, GameService gameService, UserService userService) {
        this.gameLibraryService = gameLibraryService;
        this.gameService = gameService;
        this.userService=userService;
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<GameLibraryDTO>> getGameLibraryById(@PathVariable Long id){
        List<GameLibraryDTO> library = gameLibraryService.getGameLibraryByUserId(id);
        return ResponseEntity.ok(library);
    }
    /*@PostMapping("usuario/{userId}/juego/{gameId}")
    public (@PathVariable Long userId,@PathVariable Long gameId){
        gameLibraryService.insertGameByUserId(userId,)
    }*/
    @PostMapping
    public ResponseEntity<GameLibrary> createGameLibrary(@RequestBody GameLibrary gl){

            gl.setInsertionDate(LocalDate.now());
            gl.setGame(gameService.getGameById(gl.getId().getGameId()));
        gl.setUser(userService.getUserById(gl.getId().getUserId()));

        if(gl.getStatus()==null)
            gl.setStatus(gameStatus.PENDIENTE);

        return ResponseEntity.status(HttpStatus.CREATED).body(gameLibraryService.createGameLibrary(gl));
    }
    @PutMapping("actualizarEstado/usuario/{userId}/juego/{gameId}")
    public GameLibrary updateStatusOfGameOfUser(@PathVariable Long userId, @PathVariable Long gameId,@RequestBody Map<String,String> entrada){
        String newStatusStr=entrada.get("status");
        return gameLibraryService.updateStatusOfGameOfUser(userId,gameId,gameStatus.valueOf(newStatusStr.toUpperCase()));
    }
    @DeleteMapping("eliminarJuego/usuario/{userId}/juego/{gameId}")
    public ResponseEntity<Void> deleteGameOfUser(@PathVariable Long userId,@PathVariable Long gameId){
        gameLibraryService.deleteGameByUserId(userId,gameId);
        return ResponseEntity.noContent().build();
    }
    // Agregar estos métodos en GameLibraryController.java

    @GetMapping("/ranking")
    public ResponseEntity<List<Map<String, Object>>> getRankingJuegos() {
        return ResponseEntity.ok(gameLibraryService.getRankingJuegos());
    }

    @GetMapping("/estadisticas/plataformas")
    public ResponseEntity<List<Map<String, Object>>> getEstadisticasPlataformas() {
        return ResponseEntity.ok(gameLibraryService.getEstadisticasPlataformas());
    }

    @GetMapping("/estadisticas/estados/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getEstadisticasEstados(@PathVariable Long userId) {
        return ResponseEntity.ok(gameLibraryService.getEstadisticasEstados(userId));
    }



}
