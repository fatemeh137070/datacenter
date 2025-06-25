package com.datacenter.da.entity;

import com.datacenter.service.enums.EquipmentType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Server extends Equipment {
    private String cpu;
    private Integer ramGb;
    private Integer storageGb;

    public Server() {
    }

    public Server(Long id, String model, int sizeInUnits, List<Port> ports, EquipmentType type, int portCount) {
        super(id, model, sizeInUnits, ports, type, portCount);
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