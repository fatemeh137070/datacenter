package com.datacenter.factory;

import com.datacenter.da.entity.*;
import com.datacenter.dto.*;
import org.springframework.stereotype.Component;

@Component
public class EquipmentFactory {

    public Equipment createEquipment(EquipmentDto dto) {
        if (dto == null || dto.getType() == null) {
            throw new IllegalArgumentException("EquipmentDto or its type cannot be null");
        }

        switch (dto.getType()) {
            case SERVER:
                if (!(dto instanceof ServerDto)) {
                    throw new IllegalArgumentException("ServerDto expected for type SERVER");
                }
                ServerDto serverDto = (ServerDto) dto;
                Server server = new Server();
                server.setCpu(serverDto.getCpu());
                server.setRamGb(serverDto.getRamGb());
                server.setStorageGb(serverDto.getStorageGb());
                server.setModel(dto.getModel());
                server.setPortCount(dto.getPortCount());
                server.setSizeInUnits(dto.getSizeInUnits());
                server.setType(dto.getType());
                return server;

            case SWITCH:
                Switch sw = new Switch();
                sw.setModel(dto.getModel());
                sw.setPortCount(dto.getPortCount());
                sw.setSizeInUnits(dto.getSizeInUnits());
                sw.setType(dto.getType());
                return sw;

            case PATCH_PANEL:
                PatchPanel pp = new PatchPanel();
                pp.setModel(dto.getModel());
                pp.setPortCount(dto.getPortCount());
                pp.setSizeInUnits(dto.getSizeInUnits());
                pp.setType(dto.getType());
                return pp;

            default:
                throw new IllegalArgumentException("Unknown EquipmentType: " + dto.getType());
        }
    }

    public Equipment createEquipmentById(Long id) {
        if (id == null) {
            return null;
        }
        Equipment equipment = new Equipment() {}; // anonymous subclass از کلاس abstract
        equipment.setId(id);
        return equipment;
    }
}
