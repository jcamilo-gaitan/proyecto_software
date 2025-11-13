package com.proyecto.entrega2;

import com.proyecto.entrega2.entity.Game;
import com.proyecto.entrega2.entity.gameStatus;
import com.proyecto.entrega2.entity.possibleGenres;
import com.proyecto.entrega2.entity.possiblePlatforms;
import com.proyecto.entrega2.repository.GameRepository;
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
class GameControllerIntegrationTest {

    @Value("${server.port}")
    int serverPort;

    private WebTestClient webTestClient;

    @Autowired
    private GameRepository repo;

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
        repo.save(new Game(0L, "Celeste", "lindo juego", possiblePlatforms.NINTENDO_SWITCH, possibleGenres.AVENTURA));
        repo.save(new Game(0L, "Elden Ring","lindo juego", possiblePlatforms.PLAYSTATION_5, possibleGenres.RPG));
    }

    @Test
    void listarCorrecto() {
        webTestClient.get()
                .uri(url("/api/juegos"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Game.class)
                .hasSize(2);
    }

    @Test
    void crearCorrectamente() {
        var body = Map.of(
                "title", "Hollow Knight",
                "description","buen juego",
                "platform", possiblePlatforms.PC,
                "genre", possibleGenres.METROIDVANIA

        );

        webTestClient.post()
                .uri(url("/api/juegos"))
                .bodyValue(body)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Game.class)
                .value(j -> {
                    assertEquals("Hollow Knight", j.getTitle());
                    assertEquals(possiblePlatforms.PC, j.getPlatform());
                });
    }

    @Test
    void actualizarCorrectamente() {
        Long id = repo.findByTitle("Elden Ring").getId();

        var cambios = Map.of(
                "title", "Elden Ring (Editado)",
                "description","buen juego",
                "platform", possiblePlatforms.PLAYSTATION_5,
                "genre", possibleGenres.RPG

        );

        webTestClient.put()
                .uri(url("/api/juegos/" + id))
                .bodyValue(cambios)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Game.class)
                .value(j -> {
                    assertEquals("Elden Ring (Editado)", j.getTitle());

                });
    }

    @Test
    void eliminarCorrectamente() {
        Long id = repo.findByTitle("Celeste").getId();

        webTestClient.delete()
                .uri(url("/api/juegos/" + id))
                .exchange()
                .expectStatus().isNoContent();

        webTestClient.get()
                .uri(url("/api/juegos"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Game.class)
                .hasSize(1);
    }
}