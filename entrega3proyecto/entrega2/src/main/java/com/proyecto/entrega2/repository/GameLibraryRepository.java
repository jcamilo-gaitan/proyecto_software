package com.proyecto.entrega2.repository;
import com.proyecto.entrega2.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameLibraryRepository extends JpaRepository<GameLibrary, GameLibraryID>{
    @Query("SELECT gl.game FROM GameLibrary gl WHERE gl.user.id=:userId")
    List<Game> findGamesByUserId(@Param("userId")Long userID);
    void deleteByUserId(long userId);
    void deleteByGameId(long gameId);

    @Query("SELECT gl.game FROM GameLibrary gl WHERE gl.user.id=:userId and gl.status=:estado")
    List<Game> findGamesByUserIdAndStatus(@Param("userId") Long userId,@Param("estado") String estado);
    @Query("SELECT g.title, COUNT(gl) as count " +
            "FROM GameLibrary gl JOIN gl.game g " +
            "GROUP BY g.id, g.title " +
            "ORDER BY count DESC")
    List<Object[]> findRankingJuegos();

    // Estadísticas de plataformas más frecuentes
    @Query("SELECT g.platform, COUNT(gl) as count " +
            "FROM GameLibrary gl JOIN gl.game g " +
            "GROUP BY g.platform " +
            "ORDER BY count DESC")
    List<Object[]> findEstadisticasPlataformas();

    // Estadísticas de estados por usuario
    @Query("SELECT gl.status, COUNT(gl) as count " +
            "FROM GameLibrary gl " +
            "WHERE gl.user.id = :userId " +
            "GROUP BY gl.status")
    List<Object[]> findEstadisticasByUserId(@Param("userId") Long userId);

}
