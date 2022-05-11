package application.repository;

import application.entities.VesselDeficiency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselDeficiencyRepository extends JpaRepository<VesselDeficiency, Long> {
}
