package com.proyecto.entrega2.service;
import com.proyecto.entrega2.entity.*;
import com.proyecto.entrega2.repository.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GameService {
    private final GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Game createGame(Game juego) {
        if(juego.getTitle().length()>336 || juego.getTitle().length()<=0){
            throw new ValueOutOfRangeException("El título puede tener maximo 336 caracteres y no puede ser vacio");
        }
        if(juego.getDescription().length()>3000 ){
            throw new ValueOutOfRangeException("La descripcion puede tener maximo 3000 caracteres");
        }
        return gameRepository.save(juego);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado"));
    }

    public Game getGamesByTitle(String titulo){
        return gameRepository.findByTitle(titulo);
    }
    public List<Game> getGamesByPlatform(String plataforma){
        possiblePlatforms platform = possiblePlatforms.valueOf(plataforma.toUpperCase());
        return gameRepository.findByPlatform(platform);
    }

    public Game updateGame(Long id, Game updatedjuego) {
       Game juego= getGameById(id);
       juego.setGenre(updatedjuego.getGenre());
       juego.setPlatform(updatedjuego.getPlatform());
       juego.setTitle(updatedjuego.getTitle());
       if(juego.getTitle().length()>336){
          throw new ValueOutOfRangeException("El título puede tener maximo 336 caracteres");
       }
       if(juego.getDescription().length()>3000){
            throw new ValueOutOfRangeException("La descripcion puede tener maximo 3000 caracteres");
       }

        return gameRepository.save(juego);
    }
    public void deleteGame(Long id) {
        Game juego= getGameById(id);

        gameRepository.delete(juego);

    }

}
