package com.datacenter.da.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;


@Data
@Entity
@Table(name = "rack_row")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @ManyToOne
    private DataCenter dataCenter;

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rack> racks;

    public Row() {
    }

    public Row(Long id, String label, DataCenter dataCenter, List<Rack> racks) {
        this.id = id;
        this.label = label;
        this.dataCenter = dataCenter;
        this.racks = racks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setRacks(List<Rack> racks) {
        this.racks = racks;
    }
}