package com.proyecto.entrega2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Game {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Size(max=336,message="el titulo no puede tener más de 336 caracteres")
    private String title;
    @Size(max=336,message="el titulo no puede tener más de 336 caracteres")
    private String description;

    private possiblePlatforms platform;
    @Enumerated(EnumType.STRING)
    private possibleGenres genre;

}
