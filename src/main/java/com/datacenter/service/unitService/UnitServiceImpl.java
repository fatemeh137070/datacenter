package com.datacenter.service.unitService;

import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.Rack;
import com.datacenter.da.entity.Unit;
import com.datacenter.da.repository.EquipmentRepository;
import com.datacenter.da.repository.RackRepository;
import com.datacenter.da.repository.UnitRepository;
import com.datacenter.dto.UnitDto;
import com.datacenter.mapper.unitMapper.UnitMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final RackRepository rackRepository;
    private final EquipmentRepository equipmentRepository;
    private final UnitMapper unitMapper;

    public UnitServiceImpl(UnitRepository unitRepository, RackRepository rackRepository, EquipmentRepository equipmentRepository, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.rackRepository = rackRepository;
        this.equipmentRepository = equipmentRepository;
        this.unitMapper = unitMapper;
    }

    @Override
    public List<UnitDto> findAll() {
        return unitRepository.findAll()
                .stream()
                .map(unitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UnitDto> findById(Long id) {
        return unitRepository.findById(id)
                .map(unitMapper::toDto);
    }

    @Override
    public UnitDto save(UnitDto dto) {
        Unit entity = unitMapper.toEntity(dto);

        // Fetch Rack
        Rack rack = rackRepository.findById(dto.getRackId())
                .orElseThrow(() -> new RuntimeException("Rack not found with id " + dto.getRackId()));
        entity.setRack(rack);

        // Fetch Equipment (optional)
        if (dto.getEquipmentId() != null) {
            Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                    .orElseThrow(() -> new RuntimeException("Equipment not found with id " + dto.getEquipmentId()));
            entity.setEquipment(equipment);
        } else {
            entity.setEquipment(null);
        }

        Unit saved = unitRepository.save(entity);
        return unitMapper.toDto(saved);
    }

    @Override
    public UnitDto update(Long id, UnitDto dto) {
        Unit existing = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with id " + id));

        existing.setPosition(dto.getPosition());

        Rack rack = rackRepository.findById(dto.getRackId())
                .orElseThrow(() -> new RuntimeException("Rack not found with id " + dto.getRackId()));
        existing.setRack(rack);

        if (dto.getEquipmentId() != null) {
            Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                    .orElseThrow(() -> new RuntimeException("Equipment not found with id " + dto.getEquipmentId()));
            existing.setEquipment(equipment);
        } else {
            existing.setEquipment(null);
        }

        Unit updated = unitRepository.save(existing);
        return unitMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        unitRepository.deleteById(id);
    }
}
