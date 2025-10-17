package com.proyecto.entrega2;

import com.proyecto.entrega2.entity.Juego;
import com.proyecto.entrega2.entity.estadoJuego;
import com.proyecto.entrega2.repository.JuegoRepository;
import com.proyecto.entrega2.service.JuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class JuegoServiceTest {

    @Mock
    private JuegoRepository repo;

    @InjectMocks
    private JuegoService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearJuego_guardaCorrectamente() {
        Juego juego = new Juego(0L, "Celeste", "Switch", "Plataformas", estadoJuego.RESCATADO);
        when(repo.save(any(Juego.class))).thenAnswer(i -> {
            Juego j = i.getArgument(0);
            j.setId(1L);
            return j;
        });

        Juego resultado = service.createJuego(juego);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(repo, times(1)).save(juego);
    }

    @Test
    void obtenerJuegoPorId_devuelveJuego() {
        when(repo.findById(1L)).thenReturn(Optional.of(
                new Juego(1L, "Elden Ring", "PS5", "RPG", estadoJuego.JUGANDO)
        ));

        Juego juego = service.getJuegoById(1L);

        assertThat(juego.getTitulo()).isEqualTo("Elden Ring");
        verify(repo, times(1)).findById(1L);
    }

    @Test
    void actualizarJuego_modificaCamposCorrectamente() {
        Juego existente = new Juego(1L, "Antiguo", "PC", "Acción", estadoJuego.PENDIENTE);
        when(repo.findById(1L)).thenReturn(Optional.of(existente));
        when(repo.save(any(Juego.class))).thenAnswer(i -> i.getArgument(0));

        Juego cambios = new Juego(1L, "Nuevo", "PS5", "RPG", estadoJuego.JUGANDO);
        Juego actualizado = service.updateJuego(1L, cambios);

        assertThat(actualizado.getTitulo()).isEqualTo("Nuevo");
        assertThat(actualizado.getPlataforma()).isEqualTo("PS5");
        assertThat(actualizado.getEstado()).isEqualTo(estadoJuego.JUGANDO);
    }

    @Test
    void eliminarJuego_llamaRepositorioDelete() {
        Juego juego = new Juego(2L, "Celeste", "Switch", "Plataformas", estadoJuego.RESCATADO);
        when(repo.findById(2L)).thenReturn(Optional.of(juego));

        service.deleteJuego(2L);

        verify(repo, times(1)).delete(juego);
    }
}