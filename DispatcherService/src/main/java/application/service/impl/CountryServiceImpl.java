package application.service.impl;

import application.dto.CountryDto;
import application.mapper.CountryMapper;
import application.repository.CountryRepository;
import application.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    @Override
    public Long createCountry(String engName, String rusName) {
        val countryDto = new CountryDto(engName, rusName);
        val country = countryMapper.toEntity(countryDto);
        countryRepository.save(country);
        return country.getId();
    }

    @Override
    public List<CountryDto> findAll() {
        return countryMapper.toDtos(countryRepository.findAll());
    }

    @Override
    public Optional<CountryDto> findById(Long id) {
        return countryMapper.toOptional(countryRepository.findById(id));
    }

    @Override
    public Optional<CountryDto> findByRusName(String rusName) {
        return countryMapper.toOptional(countryRepository.findByRusName(rusName));
    }

    @Override
    public Optional<CountryDto> findByEngName(String engName) {
        return countryMapper.toOptional(countryRepository.findByEngName(engName));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String engName, String rusName) {
        countryRepository.findById(id).ifPresent(c -> {
            c.setEngName(engName);
            c.setRusName(rusName);
            countryRepository.save(c);
        });
    }
}
