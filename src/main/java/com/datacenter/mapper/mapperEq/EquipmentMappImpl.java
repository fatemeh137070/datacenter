package com.datacenter.mapper.mapperEq;

import com.datacenter.da.entity.*;
import com.datacenter.dto.EquipmentDto;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMappImpl {

    public EquipmentDto toDto(Equipment entity) {
        EquipmentDto dto = new EquipmentDto();
        dto.setId(entity.getId());
        dto.setModel(entity.getModel());
        dto.setSizeInUnits(entity.getSizeInUnits());
        dto.setPortCount(entity.getPortCount());
        dto.setType(entity.getType());

        if (entity instanceof Server server) {
            dto.setCpu(server.getCpu());
            dto.setRamGb(server.getRamGb());
            dto.setStorageGb(server.getStorageGb());
        }

        return dto;
    }

    public Equipment toEntity(EquipmentDto dto) {
        Equipment equipment;
        switch (dto.getType()) {
            case SERVER -> {
                Server server = new Server();
                server.setCpu(dto.getCpu());
                server.setRamGb(dto.getRamGb());
                server.setStorageGb(dto.getStorageGb());
                equipment = server;
            }
            case SWITCH -> equipment = new Switch();
            case PATCH_PANEL -> equipment = new PatchPanel();
            default -> throw new IllegalArgumentException("Unsupported EquipmentType");
        }

        equipment.setId(dto.getId());
        equipment.setModel(dto.getModel());
        equipment.setSizeInUnits(dto.getSizeInUnits());
        equipment.setPortCount(dto.getPortCount());
        equipment.setType(dto.getType());

        return equipment;
    }
}
