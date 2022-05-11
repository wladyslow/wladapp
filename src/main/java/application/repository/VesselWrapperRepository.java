package application.repository;

import application.entities.VesselWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselWrapperRepository extends JpaRepository<VesselWrapper, Long> {
}
