package com.datacenter.service.equipmentPlacementService;

import com.datacenter.dto.EquipmentPlacementDto;

import java.util.List;
import java.util.Optional;

public interface EquipmentPlacementService {
    List<EquipmentPlacementDto> findAll();
    Optional<EquipmentPlacementDto> findById(Long id);
    EquipmentPlacementDto save(EquipmentPlacementDto dto);
    EquipmentPlacementDto update(Long id, EquipmentPlacementDto dto);
    void delete(Long id);
}
