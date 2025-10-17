package com.proyecto.entrega2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Juego {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String plataforma;
    private String genero;
    @Enumerated(EnumType.STRING)
    private estadoJuego estado;

}
