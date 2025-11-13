package com.proyecto.entrega2;

import com.proyecto.entrega2.entity.Game;
import com.proyecto.entrega2.entity.gameStatus;
import com.proyecto.entrega2.entity.possibleGenres;
import com.proyecto.entrega2.entity.possiblePlatforms;
import com.proyecto.entrega2.repository.GameRepository;
import com.proyecto.entrega2.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    @Mock
    private GameRepository repo;

    @InjectMocks
    private GameService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearJuego_guardaCorrectamente() {
        Game juego = new Game(0L, "Celeste", "lindo juego", possiblePlatforms.NINTENDO_SWITCH, possibleGenres.AVENTURA);
        when(repo.save(any(Game.class))).thenAnswer(i -> {
            Game j = i.getArgument(0);
            j.setId(1L);
            return j;
        });

        Game resultado = service.createGame(juego);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(repo, times(1)).save(juego);
    }

    @Test
    void obtenerJuegoPorId_devuelveJuego() {
        when(repo.findById(1L)).thenReturn(Optional.of(
                new Game(0L, "Elden Ring","lindo juego", possiblePlatforms.PLAYSTATION_5, possibleGenres.RPG)
        ));

        Game juego = service.getGameById(1L);

        assertThat(juego.getTitle()).isEqualTo("Elden Ring");
        verify(repo, times(1)).findById(1L);
    }

    @Test
    void actualizarJuego_modificaCamposCorrectamente() {
        Game existente = new Game(1L, "Antiguo","Juego desconocido", possiblePlatforms.PC, possibleGenres.ACCION);
        when(repo.findById(1L)).thenReturn(Optional.of(existente));
        when(repo.save(any(Game.class))).thenAnswer(i -> i.getArgument(0));

        Game cambios = new Game(1L, "Nuevo","Juego desconocido", possiblePlatforms.PLAYSTATION_5, possibleGenres.RPG);
        Game actualizado = service.updateGame(1L, cambios);

        assertThat(actualizado.getTitle()).isEqualTo("Nuevo");
        assertThat(actualizado.getPlatform()).isEqualTo(possiblePlatforms.PLAYSTATION_5);

    }

    @Test
    void eliminarJuego_llamaRepositorioDelete() {
        Game juego = new Game(2L, "Celeste","lindo juego", possiblePlatforms.NINTENDO_SWITCH, possibleGenres.AVENTURA);
        when(repo.findById(2L)).thenReturn(Optional.of(juego));

        service.deleteGame(2L);

        verify(repo, times(1)).delete(juego);
    }
}