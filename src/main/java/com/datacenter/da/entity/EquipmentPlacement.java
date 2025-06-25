package com.datacenter.da.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class EquipmentPlacement {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Equipment equipment;

    @ManyToOne
    private Rack rack;

    private int startUnit;
    private int size;

    public EquipmentPlacement() {
    }

    public EquipmentPlacement(Long id, Equipment equipment, Rack rack, int startUnit, int size) {
        this.id = id;
        this.equipment = equipment;
        this.rack = rack;
        this.startUnit = startUnit;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
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