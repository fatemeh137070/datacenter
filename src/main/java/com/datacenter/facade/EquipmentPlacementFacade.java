package com.datacenter.facade;

import com.datacenter.dto.EquipmentPlacementDto;
import com.datacenter.service.equipmentPlacementService.EquipmentPlacementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EquipmentPlacementFacade {

    public EquipmentPlacementFacade(EquipmentPlacementService service) {
        this.service = service;
    }

    private final EquipmentPlacementService service;

    public List<EquipmentPlacementDto> findAll() {
        return service.findAll();
    }

    public Optional<EquipmentPlacementDto> findById(Long id) {
        return service.findById(id);
    }

    public EquipmentPlacementDto save(EquipmentPlacementDto dto) {
        return service.save(dto);
    }

    public EquipmentPlacementDto update(Long id, EquipmentPlacementDto dto) {
        return service.update(id, dto);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
