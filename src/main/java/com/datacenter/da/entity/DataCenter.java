package com.datacenter.da.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.*;

@Data
@Entity
@Table(name = "dataCenters")
public class DataCenter {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "dataCenter")
    private List<Row> rows;



    public DataCenter() {
    }

    public DataCenter(Long id, String name, Location location, List<Row> rows) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rows = rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}