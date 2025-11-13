package com.proyecto.entrega2.repository;
import com.proyecto.entrega2.entity.gameStatus;
import java.util.List;
import com.proyecto.entrega2.entity.User;
import com.proyecto.entrega2.entity.possiblePlatforms;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {

}
