package com.datacenter.da.entity;
import com.datacenter.service.enums.EquipmentType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipment {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int sizeInUnits;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Port> ports;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    private int portCount;// اضافه کردن این فیلد

    public Equipment() {
    }

    public Equipment(Long id, String model, int sizeInUnits, List<Port> ports, EquipmentType type, int portCount) {
        this.id = id;
        this.model = model;
        this.sizeInUnits = sizeInUnits;
        this.ports = ports;
        this.type = type;
        this.portCount = portCount;
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

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public int getPortCount() {
        return portCount;
    }

    public void setPortCount(int portCount) {
        this.portCount = portCount;
    }
}