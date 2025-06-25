package com.datacenter.dto;

import com.datacenter.service.enums.EquipmentType;
import com.datacenter.service.enums.PortType;
import lombok.Data;

@Data
public class PortDto {
    private Long id;
    private int number;
    private Long equipmentId;
    private boolean active;
    private PortType portType;
    public PortDto() {
    }

    public PortDto(Long id, int number, Long equipmentId, boolean active, PortType portType) {
        this.id = id;
        this.number = number;
        this.equipmentId = equipmentId;
        this.active = active;
        this.portType = portType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PortType getPortType() {
        return portType;
    }

    public void setPortType(PortType portType) {
        this.portType = portType;
    }
}
