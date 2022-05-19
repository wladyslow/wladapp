package application.repository;

import application.entities.VesselToClear;
import application.enums.VesselToClearStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VesselToClearRepository extends JpaRepository<VesselToClear, Long> {

    List<VesselToClear> findByStatus(VesselToClearStatus vesselToClearStatus);

    List<VesselToClear> findByLoadingWindowId(Long loadinWindowId);

}
