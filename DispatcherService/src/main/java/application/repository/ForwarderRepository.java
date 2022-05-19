package application.repository;

import application.entities.Forwarder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForwarderRepository extends JpaRepository<Forwarder, Long> {
}
