package application.repository;

import application.entities.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VesselRepository extends JpaRepository<Vessel, Long> {

    List<Vessel> findAllByOrderByNameAsc();

    Optional<Vessel> findByName(String name);

    Optional<Vessel> findByImo(int imo);

    boolean existsVesselByImo(int imo);
}
