package com.proyecto.entrega2.service;

import com.proyecto.entrega2.dto.GameLibraryDTO;
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
    // MÉTODO CORREGIDO: Actualizar estado
    public GameLibrary updateStatusOfGameOfUser(Long userId, Long gameId, gameStatus newStatus) {
        System.out.println("🔍 Buscando juego - userId: " + userId + ", gameId: " + gameId);

        // Buscar usando el método personalizado del repositorio
        GameLibrary gameLibrary = gameLibraryRepository.findByIdUserIdAndIdGameId(userId, gameId)
                .orElseThrow(() -> {
                    System.out.println("❌ No se encontró el juego en la biblioteca");
                    return new ResourceNotFoundException("Parece que no tienes ese juego");
                });

        System.out.println("✅ Juego encontrado: " + gameLibrary.getGame().getTitle());

        // Actualizar el estado
        gameLibrary.setStatus(newStatus);

        // Guardar y retornar
        GameLibrary saved = gameLibraryRepository.save(gameLibrary);
        System.out.println("✅ Estado actualizado a: " + saved.getStatus());
        return saved;
    }

    // MÉTODO CORREGIDO: Eliminar juego
    public void deleteGameByUserId(Long userId, Long gameId) {
        System.out.println("🗑️ Intentando eliminar - userId: " + userId + ", gameId: " + gameId);

        // Buscar usando el método personalizado
        GameLibrary gameLibrary = gameLibraryRepository.findByIdUserIdAndIdGameId(userId, gameId)
                .orElseThrow(() -> {
                    System.out.println("❌ No se encontró el juego para eliminar");
                    return new ResourceNotFoundException("Parece que no tienes ese juego");
                });

        System.out.println("✅ Juego encontrado, procediendo a eliminar: " + gameLibrary.getGame().getTitle());

        // Eliminar
        gameLibraryRepository.delete(gameLibrary);
        System.out.println("✅ Juego eliminado correctamente");
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
    // En GameLibraryService.java
    public List<GameLibraryDTO> getGameLibraryByUserId(Long userId) {
        List<GameLibrary> gameLibraries = gameLibraryRepository.findByIdUserId(userId);

        return gameLibraries.stream()
                .map(gl -> new GameLibraryDTO(
                        gl.getGame().getId(),
                        gl.getGame().getTitle(),
                        gl.getGame().getDescription(),
                        gl.getGame().getPlatform().toString(),
                        gl.getGame().getGenre().toString(),
                        gl.getStatus(),
                        gl.getInsertionDate()
                ))
                .collect(Collectors.toList());
    }

}


