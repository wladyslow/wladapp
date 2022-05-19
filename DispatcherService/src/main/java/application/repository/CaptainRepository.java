package application.repository;

import application.entities.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaptainRepository extends JpaRepository<Captain, Long> {
    Optional<Captain> findByName(String name);
}
