package com.datacenter.dto;


import lombok.Data;

@Data
public class UnitDto {
    private Long id;
    private int position;
    private Long rackId;
    private Long equipmentId;

    public UnitDto() {
    }

    public UnitDto(Long id, int position, Long rackId, Long equipmentId) {
        this.id = id;
        this.position = position;
        this.rackId = rackId;
        this.equipmentId = equipmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
