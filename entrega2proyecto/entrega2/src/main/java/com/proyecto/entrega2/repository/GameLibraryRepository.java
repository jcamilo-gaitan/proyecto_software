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

}
