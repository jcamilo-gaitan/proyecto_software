package com.proyecto.entrega2.repository;
import com.proyecto.entrega2.entity.gameStatus;
import java.util.List;
import java.util.Optional;

import com.proyecto.entrega2.entity.User;
import com.proyecto.entrega2.entity.possiblePlatforms;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
