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
import java.util.List;
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

}
