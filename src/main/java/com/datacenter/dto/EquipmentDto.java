package com.datacenter.dto;

import com.datacenter.service.enums.EquipmentType;
import lombok.Data;

@Data
public class EquipmentDto {
    private Long id;
    private String model;
    private int sizeInUnits;
    private int portCount;
    private EquipmentType type; // ENUM



    public EquipmentDto(Long id, String model, int sizeInUnits, int portCount, EquipmentType type, String cpu, Integer ramGb, Integer storageGb) {
        this.id = id;
        this.model = model;
        this.sizeInUnits = sizeInUnits;
        this.portCount = portCount;
        this.type = type;
    }


    public EquipmentDto() {
    }

    public EquipmentDto(Long id, String model, int sizeInUnits, int portCount, EquipmentType type) {
        this.id = id;
        this.model = model;
        this.sizeInUnits = sizeInUnits;
        this.portCount = portCount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSizeInUnits() {
        return sizeInUnits;
    }

    public void setSizeInUnits(int sizeInUnits) {
        this.sizeInUnits = sizeInUnits;
    }

    public int getPortCount() {
        return portCount;
    }

    public void setPortCount(int portCount) {
        this.portCount = portCount;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

}
