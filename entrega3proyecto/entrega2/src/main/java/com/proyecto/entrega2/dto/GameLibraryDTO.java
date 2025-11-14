package com.proyecto.entrega2.dto;

import com.proyecto.entrega2.entity.gameStatus;
import java.time.LocalDate;

public class GameLibraryDTO {
    private Long id;  // ID del juego
    private String title;
    private String description;
    private String platform;
    private String genre;
    private gameStatus status;
    private LocalDate insertionDate;

    public GameLibraryDTO() {}

    public GameLibraryDTO(Long id, String title, String description, String platform,
                          String genre, gameStatus status, LocalDate insertionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.platform = platform;
        this.genre = genre;
        this.status = status;
        this.insertionDate = insertionDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public gameStatus getStatus() {
        return status;
    }

    public void setStatus(gameStatus status) {
        this.status = status;
    }

    public LocalDate getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(LocalDate insertionDate) {
        this.insertionDate = insertionDate;
    }
}