package com.proyecto.entrega2.service;
import com.proyecto.entrega2.repository.JuegoRepository;
import com.proyecto.entrega2.entity.ResourceNotFoundException;
import java.util.List;
import com.proyecto.entrega2.entity.estadoJuego;
import com.proyecto.entrega2.entity.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JuegoService {
    private final JuegoRepository juegoRepository;
    @Autowired
    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }
    public Juego createJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }

    public Juego getJuegoById(Long id) {
        return juegoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado"));
    }
    public List<Juego> getJuegosByEstado(estadoJuego estado) {
        return juegoRepository.findByEstado(estado);
    }
    public Juego getJuegoByTitulo(String titulo){
        return juegoRepository.findByTitulo(titulo);
    }
    public List<Juego> getJuegosByPlataforma(String plataforma){
        return juegoRepository.findByPlataforma(plataforma);
    }

    public Juego updateJuego(Long id, Juego updatedjuego) {
       Juego juego= getJuegoById(id);
       juego.setGenero(updatedjuego.getGenero());
       juego.setPlataforma(updatedjuego.getPlataforma());
       juego.setTitulo(updatedjuego.getTitulo());
       juego.setEstado(updatedjuego.getEstado());
        return juegoRepository.save(juego);
    }

    public void deleteJuego(Long id) {
        Juego juego= getJuegoById(id);

        juegoRepository.delete(juego);

    }
}
