package application.repository;

import application.entities.VesselDeficiency;
import application.entities.VesselWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VesselDeficiencyRepository extends JpaRepository<VesselDeficiency, Long> {

    List<VesselDeficiency> findByVesselWrapper(VesselWrapper vesselWrapper);
}
