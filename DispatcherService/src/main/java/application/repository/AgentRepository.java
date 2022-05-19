package application.repository;

import application.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByName(String name);

    Optional<Agent> findByRusFullName(String rusFullName);
}
