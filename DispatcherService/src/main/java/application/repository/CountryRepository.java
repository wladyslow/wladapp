package application.repository;

import application.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByRusName(String rusName);

    Optional<Country> findByEngName(String engName);
}
