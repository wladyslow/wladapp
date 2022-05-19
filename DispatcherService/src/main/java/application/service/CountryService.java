package application.service;


import application.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Long createCountry(String engName, String rusName);

    List<CountryDto> findAll();

    Optional<CountryDto> findById(Long id);

    Optional<CountryDto> findByRusName(String rusName);

    Optional<CountryDto> findByEngName(String engName);

    void deleteById(Long id);

    void update(Long id, String engName, String rusName);
}
