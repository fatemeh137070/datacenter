package com.datacenter.da.entity;

import com.datacenter.service.enums.PortType;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "ports")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;

    @Enumerated(EnumType.STRING)
    private PortType portType;

    private boolean active;

    @ManyToOne
    private Equipment equipment;

    public Port() {
    }

    public Port(Long id, int number, PortType portType, boolean active, Equipment equipment) {
        this.id = id;
        this.number = number;
        this.portType = portType;
        this.active = active;
        this.equipment = equipment;
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

    public PortType getPortType() {
        return portType;
    }

    public void setPortType(PortType portType) {
        this.portType = portType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}