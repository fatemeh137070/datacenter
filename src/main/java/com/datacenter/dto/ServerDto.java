package com.datacenter.dto;

import com.datacenter.service.enums.EquipmentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServerDto extends EquipmentDto {
    private String cpu;
    private Integer ramGb;
    private Integer storageGb;


    public ServerDto() {
    }

    public ServerDto(Long id, String model, int sizeInUnits, int portCount, EquipmentType type, String cpu, Integer ramGb, Integer storageGb) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
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
}
