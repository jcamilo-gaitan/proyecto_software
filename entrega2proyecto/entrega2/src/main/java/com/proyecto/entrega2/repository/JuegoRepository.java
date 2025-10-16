package com.proyecto.entrega2.repository;
import com.proyecto.entrega2.entity.estadoJuego;
import java.util.List;
import com.proyecto.entrega2.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JuegoRepository extends JpaRepository<Juego, Long> {
    List<Juego> findByEstado(estadoJuego estado);
    Juego findByTitulo(String titulo);
    List<Juego> findByPlataforma(String plataforma);
}
