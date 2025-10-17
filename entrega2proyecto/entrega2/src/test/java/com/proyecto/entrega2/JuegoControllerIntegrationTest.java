package com.proyecto.entrega2;

import com.proyecto.entrega2.entity.Juego;
import com.proyecto.entrega2.entity.estadoJuego;
import com.proyecto.entrega2.repository.JuegoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration-testing")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class JuegoControllerIntegrationTest {

    @Value("${server.port}")
    int serverPort;

    private WebTestClient webTestClient;

    @Autowired
    private JuegoRepository repo;

    private String url(String path) {
        return "http://localhost:" + serverPort + path;
    }

    @BeforeEach
    void init() {
        // Construimos el cliente apuntando al puerto definido (como el ejemplo)
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + serverPort)
                .build();

        // Semilla mínima para cada prueba
        repo.deleteAll();
        repo.save(new Juego(0L, "Celeste", "Switch", "Plataformas", estadoJuego.RESCATADO));
        repo.save(new Juego(0L, "Elden Ring", "PS5", "RPG", estadoJuego.JUGANDO));
    }

    @Test
    void listarCorrecto() {
        webTestClient.get()
                .uri(url("/api/juegos"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Juego.class)
                .hasSize(2);
    }

    @Test
    void crearCorrectamente() {
        var body = Map.of(
                "titulo", "Hollow Knight",
                "plataforma", "PC",
                "genero", "Metroidvania",
                "estado", estadoJuego.PENDIENTE.name()
        );

        webTestClient.post()
                .uri(url("/api/juegos"))
                .bodyValue(body)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Juego.class)
                .value(j -> {
                    assertEquals("Hollow Knight", j.getTitulo());
                    assertEquals("PC", j.getPlataforma());
                });
    }

    @Test
    void actualizarCorrectamente() {
        Long id = repo.findByTitulo("Elden Ring").getId();

        var cambios = Map.of(
                "titulo", "Elden Ring (Editado)",
                "plataforma", "PS5",
                "genero", "RPG",
                "estado", estadoJuego.RESCATADO.name()
        );

        webTestClient.put()
                .uri(url("/api/juegos/" + id))
                .bodyValue(cambios)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Juego.class)
                .value(j -> {
                    assertEquals("Elden Ring (Editado)", j.getTitulo());
                    assertEquals(estadoJuego.RESCATADO, j.getEstado());
                });
    }

    @Test
    void eliminarCorrectamente() {
        Long id = repo.findByTitulo("Celeste").getId();

        webTestClient.delete()
                .uri(url("/api/juegos/" + id))
                .exchange()
                .expectStatus().isNoContent();

        webTestClient.get()
                .uri(url("/api/juegos"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Juego.class)
                .hasSize(1);
    }
}