package application.repository;

import application.entities.VesselWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VesselWrapperRepository extends JpaRepository<VesselWrapper, Long> {

    Optional<VesselWrapper> findByImo(int imo);

    boolean existsVesselWrapperByImo(int imo);
}
