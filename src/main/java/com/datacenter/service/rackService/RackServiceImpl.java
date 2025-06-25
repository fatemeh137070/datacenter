package com.datacenter.service.rackService;

import com.datacenter.da.entity.Row;
import com.datacenter.da.entity.Rack;
import com.datacenter.da.repository.RackRepository;
import com.datacenter.da.repository.RowRepository;
import com.datacenter.dto.RackDto;
import com.datacenter.mapper.RackMapper;
import com.datacenter.service.rackService.RackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class RackServiceImpl implements RackService {

    private final RackRepository rackRepository;
    private final RowRepository rowRepository;
    private final RackMapper rackMapper;

    public RackServiceImpl(RackRepository rackRepository, RowRepository rowRepository, RackMapper rackMapper) {
        this.rackRepository = rackRepository;
        this.rowRepository = rowRepository;
        this.rackMapper = rackMapper;
    }

    @Override
    public List<RackDto> findAll() {
        return rackRepository.findAll()
                .stream()
                .map(rackMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RackDto> findById(Long id) {
        return rackRepository.findById(id)
                .map(rackMapper::toDto);
    }

    @Override
    public RackDto save(RackDto dto) {
        Rack rack = rackMapper.toEntity(dto);
        if (dto.getRowId() != null) {
            Row row = rowRepository.findById(dto.getRowId())
                    .orElseThrow(() -> new RuntimeException("Row not found with id " + dto.getRowId()));
            rack.setRow(row);
        }
        Rack saved = rackRepository.save(rack);
        return rackMapper.toDto(saved);
    }

    @Override
    public RackDto update(Long id, RackDto dto) {
        Rack existing = rackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rack not found with id " + id));
        existing.setLabel(dto.getLabel());
        if (dto.getRowId() != null) {
            Row row = rowRepository.findById(dto.getRowId())
                    .orElseThrow(() -> new RuntimeException("Row not found with id " + dto.getRowId()));
            existing.setRow(row);
        }
        Rack updated = rackRepository.save(existing);
        return rackMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        rackRepository.deleteById(id);
    }
}
