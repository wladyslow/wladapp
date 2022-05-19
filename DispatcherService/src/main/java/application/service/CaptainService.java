package application.service;

import application.dto.CaptainDto;

import java.util.List;
import java.util.Optional;

public interface CaptainService {

    Long createCaptain(String name);

    List<CaptainDto> findAll();

    Optional<CaptainDto> findById(Long id);

    Optional<CaptainDto> findByName(String name);

    void deleteById(Long id);

    void update(Long id, String name);
}

