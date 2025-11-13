package com.proyecto.entrega2.service;

import com.proyecto.entrega2.entity.*;
import com.proyecto.entrega2.repository.GameLibraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.proyecto.entrega2.service.GameService;
import com.proyecto.entrega2.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameLibraryService {
    private final GameLibraryRepository gameLibraryRepository;
    private final GameService gameService;
    private final UserService userService;
    @Autowired
    GameLibraryService(GameLibraryRepository gameLibraryRepository,GameService gameService,UserService userService) {
        this.gameLibraryRepository = gameLibraryRepository;
        this.gameService = gameService;
        this.userService = userService;
    }
    public GameLibrary createGameLibrary(GameLibrary gameLibrary) {
        return gameLibraryRepository.save(gameLibrary);
    }
    public List<Game> getGamesByUserId(Long userId) {
        return gameLibraryRepository.findGamesByUserId(userId);
    }
    public void deleteGameByUserId(Long userId, Long gameId){
        GameLibraryID id=new GameLibraryID(userId,gameId);
        gameLibraryRepository.deleteById(id);
    }
    public void deleteAllGamesByUserId(Long userId) {
        gameLibraryRepository.deleteByUserId(userId);
    }
    public void deleteAllUsersByGame(long gameId){
        gameLibraryRepository.deleteByGameId(gameId);
    }
    public GameLibrary insertGameByUserId(Long userId, Long gameId){
        GameLibraryID id=new GameLibraryID(userId,gameId);
        GameLibrary registro=new GameLibrary(id,userService.getUserById(userId),gameService.getGameById(gameId), gameStatus.PENDIENTE,LocalDate.now());
        return gameLibraryRepository.save(registro);
    }
    public List<Game> getGamesByUserIdAndStatus(Long userId,String status){
        return gameLibraryRepository.findGamesByUserIdAndStatus(userId,status);
    }
    public GameLibrary updateStatusOfGameOfUser(Long userId,Long gameId,gameStatus gameStatus){
        GameLibraryID id=new GameLibraryID(userId,gameId);
        GameLibrary gl=gameLibraryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Parece que no tienes ese juego"));
        gl.setStatus(gameStatus);
        gl.setInsertionDate(LocalDate.now());
        return gameLibraryRepository.save(gl);
    }
    // ==================== MÉTODOS DE ESTADÍSTICAS ====================

    /**
     * Obtiene el ranking de juegos más guardados por todos los usuarios
    @return Lista de mapas con título del juego y cantidad de usuarios que lo tienen
     */
    public List<Map<String, Object>> getRankingJuegos() {
        List<Object[]> results = gameLibraryRepository.findRankingJuegos();

        return results.stream()
                .limit(10) // Top 10
                .map(result -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("title", result[0]);
                    map.put("count", result[1]);
                    return map;
                })
                .collect(Collectors.toList());
    }

    /**
     * Obtiene estadísticas de las plataformas más frecuentes en todas las bibliotecas
     * @return Lista de mapas con plataforma y cantidad de juegos
     */
    public List<Map<String, Object>> getEstadisticasPlataformas() {
        List<Object[]> results = gameLibraryRepository.findEstadisticasPlataformas();

        return results.stream()
                .map(result -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("platform", result[0]);
                    map.put("count", result[1]);
                    return map;
                })
                .collect(Collectors.toList());
    }

    /**
     * Obtiene estadísticas de estados de juegos para un usuario específico
     * @param userId ID del usuario
     * @return Lista de mapas con estado y cantidad de juegos en ese estado
     */
    public List<Map<String, Object>> getEstadisticasEstados(Long userId) {
        List<Object[]> results = gameLibraryRepository.findEstadisticasByUserId(userId);

        return results.stream()
                .map(result -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", result[0].toString());
                    map.put("count", result[1]);
                    return map;
                })
                .collect(Collectors.toList());
    }

}


