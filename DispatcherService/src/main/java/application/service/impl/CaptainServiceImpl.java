package application.service.impl;

import application.dto.CaptainDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import application.mapper.CaptainMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.CaptainRepository;
import application.service.CaptainService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaptainServiceImpl implements CaptainService {

    private final CaptainRepository captainRepository;
    private final CaptainMapper captainMapper;

    @Override
    @Transactional
    public Long createCaptain(String name) {
        val captainDto = new CaptainDto(name);
        val captain = captainMapper.toEntity(captainDto);
        captainRepository.save(captain);
        return captain.getId();
    }

    @Override
    @Transactional
    public List<CaptainDto> findAll() {
        return captainMapper.toDtos(captainRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<CaptainDto> findById(Long id) {
        return captainMapper.toOptional(captainRepository.findById(id));
    }

    @Override
    @Transactional
    public Optional<CaptainDto> findByName(String name) {
        return captainMapper.toOptional(captainRepository.findByName(name));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        captainRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        captainRepository.findById(id).ifPresent(captain -> captain.setName(name));
    }
}
