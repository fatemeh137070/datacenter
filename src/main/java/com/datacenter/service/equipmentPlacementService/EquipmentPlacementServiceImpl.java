package com.datacenter.service.equipmentPlacementService;

import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.EquipmentPlacement;
import com.datacenter.da.entity.Rack;
import com.datacenter.da.repository.EquipmentPlacementRepository;
import com.datacenter.da.repository.EquipmentRepository;
import com.datacenter.da.repository.RackRepository;
import com.datacenter.dto.EquipmentPlacementDto;
import com.datacenter.mapper.EquipmentPlacementMapper;
import com.datacenter.service.equipmentPlacementService.EquipmentPlacementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EquipmentPlacementServiceImpl implements EquipmentPlacementService {

    private final EquipmentPlacementRepository repository;
    private final EquipmentPlacementMapper mapper;
    private final EquipmentRepository equipmentRepository;
    private final RackRepository rackRepository;

    public EquipmentPlacementServiceImpl(EquipmentPlacementRepository repository, EquipmentPlacementMapper mapper, EquipmentRepository equipmentRepository, RackRepository rackRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.equipmentRepository = equipmentRepository;
        this.rackRepository = rackRepository;
    }

    @Override
    public List<EquipmentPlacementDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<EquipmentPlacementDto> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }


    @Override
    public EquipmentPlacementDto save(EquipmentPlacementDto dto) {
        EquipmentPlacement entity = mapper.toEntity(dto);

        Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found"));
        Rack rack = rackRepository.findById(dto.getRackId())
                .orElseThrow(() -> new EntityNotFoundException("Rack not found"));

        entity.setEquipment(equipment);
        entity.setRack(rack);

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EquipmentPlacementDto update(Long id, EquipmentPlacementDto dto) {
        EquipmentPlacement placement = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Placement not found with id " + id));

        Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found with id " + dto.getEquipmentId()));

        Rack rack = rackRepository.findById(dto.getRackId())
                .orElseThrow(() -> new EntityNotFoundException("Rack not found with id " + dto.getRackId()));

        placement.setEquipment(equipment);
        placement.setRack(rack);
        placement.setStartUnit(dto.getStartUnit());
        placement.setSize(dto.getSize());

        EquipmentPlacement updated = repository.save(placement);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
