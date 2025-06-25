package com.datacenter.service.switchService;

import com.datacenter.da.entity.Switch;
import com.datacenter.da.repository.SwitchRepository;
import com.datacenter.dto.SwitchDto;
import com.datacenter.mapper.SwitchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SwitchServiceImpl implements SwitchService {

    private final SwitchRepository switchRepository;
    private final SwitchMapper switchMapper;

    public SwitchServiceImpl(SwitchRepository switchRepository, SwitchMapper switchMapper) {
        this.switchRepository = switchRepository;
        this.switchMapper = switchMapper;
    }

    @Override
    public List<SwitchDto> findAll() {
        return switchRepository.findAll()
                .stream()
                .map(switchMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SwitchDto> findById(Long id) {
        return switchRepository.findById(id)
                .map(switchMapper::toDto);
    }

    @Override
    public SwitchDto save(SwitchDto dto) {
        Switch entity = switchMapper.toEntity(dto);
        Switch saved = switchRepository.save(entity);
        return switchMapper.toDto(saved);
    }

    @Override
    public SwitchDto update(Long id, SwitchDto dto) {
        Switch existing = switchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Switch not found with id " + id));

        existing.setModel(dto.getModel());
        existing.setSizeInUnits(dto.getSizeInUnits());
        existing.setPortCount(dto.getPortCount());
        existing.setType(dto.getType());

        Switch updated = switchRepository.save(existing);
        return switchMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        switchRepository.deleteById(id);
    }
}
