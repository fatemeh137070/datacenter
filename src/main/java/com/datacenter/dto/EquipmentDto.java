package com.datacenter.dto;

import com.datacenter.service.enums.EquipmentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EquipmentDto {
    private Long id;
    private String model;
    private int sizeInUnits;
    private int portCount;
    private String cpu;
    private Integer ramGb;
    private Integer storageGb;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    public EquipmentDto(EquipmentType type) {
        this.type = type;
    }

    public EquipmentType getType() {
        return type;
    }


    public EquipmentDto(Long id, String model, int sizeInUnits, int portCount, String cpu, Integer ramGb, Integer storageGb) {
        this.id = id;
        this.model = model;
        this.sizeInUnits = sizeInUnits;
        this.portCount = portCount;
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRamGb() {
        return ramGb;
    }

    public void setRamGb(Integer ramGb) {
        this.ramGb = ramGb;
    }

    public Integer getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(Integer storageGb) {
        this.storageGb = storageGb;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public EquipmentDto() {
    }
}
