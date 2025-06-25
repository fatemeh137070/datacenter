package com.datacenter.dto;

import lombok.Data;

@Data
public class EquipmentPlacementDto {
    private Long id;
    private Long equipmentId;
    private Long rackId;
    private int startUnit;
    private int size;
    public EquipmentPlacementDto() {
    }

    public EquipmentPlacementDto(Long id, Long equipmentId, Long rackId, int startUnit, int size) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.rackId = rackId;
        this.startUnit = startUnit;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public int getStartUnit() {
        return startUnit;
    }

    public void setStartUnit(int startUnit) {
        this.startUnit = startUnit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
