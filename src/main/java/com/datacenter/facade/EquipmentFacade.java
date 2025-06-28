package com.datacenter.facade;

import com.datacenter.da.entity.Equipment;
import com.datacenter.dto.EquipmentDto;
import com.datacenter.mapper.EquipmentMapper;
import com.datacenter.mapper.EquipmentMapperImpl;
import com.datacenter.mapper.mapperEq.EquipmentMappImpl;
import com.datacenter.service.equipmentService.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component

public class EquipmentFacade {

    private final EquipmentService equipmentService;
    private final EquipmentMapper equipmentMapper;
    private final EquipmentMappImpl mapper;


    public EquipmentFacade(EquipmentService equipmentService, EquipmentMapper equipmentMapper, EquipmentMapperImpl mapper, EquipmentMappImpl mapper1) {
        this.equipmentService = equipmentService;
        this.equipmentMapper = equipmentMapper;
        this.mapper = mapper1;
    }

    public List<EquipmentDto> findAll() {
        List<Equipment> equipments = equipmentService.findAll();
        return equipments.stream()
                .map(equipmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EquipmentDto> findById(Long id) {
        return equipmentService.findById(id)
                .map(equipmentMapper::toDto);
    }

    public EquipmentDto save(EquipmentDto dto) {
        Equipment equipment = mapper.toEntity(dto);
        Equipment saved = equipmentService.save(equipment);
        return equipmentMapper.toDto(saved);
    }



    public EquipmentDto update(EquipmentDto dto) {
        Equipment equipment = mapper.toEntity(dto);
        Equipment updated = equipmentService.update(equipment);
        return equipmentMapper.toDto(updated);
    }

    public void delete(Long id) {
        equipmentService.delete(id);
    }
}
