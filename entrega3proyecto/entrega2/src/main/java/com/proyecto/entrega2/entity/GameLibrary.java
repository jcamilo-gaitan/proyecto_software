package com.proyecto.entrega2.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GameLibrary {
    @EmbeddedId
    private GameLibraryID id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name="game_id")
    private Game game;
    @Enumerated(EnumType.STRING)
    private gameStatus status;
    private LocalDate insertionDate;

}
