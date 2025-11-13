package com.proyecto.entrega2.repository;
import com.proyecto.entrega2.entity.gameStatus;
import java.util.List;
import com.proyecto.entrega2.entity.Game;
import com.proyecto.entrega2.entity.possiblePlatforms;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String titulo);
    List<Game> findByPlatform(possiblePlatforms platform);
}
