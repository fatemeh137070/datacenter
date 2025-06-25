package com.datacenter.dto;

import lombok.Data;

@Data
public class DataCenterDto {
    private Long id;
    private String name;
    private Long locationId;

    public DataCenterDto() {
    }

    public DataCenterDto(Long id, String name, Long locationId) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}