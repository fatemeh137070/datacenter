package com.datacenter.dto;

import lombok.Data;

import java.util.List;

@Data
public class LocationDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<Long> childIds;

    public LocationDto() {
    }

    public LocationDto(Long id, String name, Long parentId, List<Long> childIds) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childIds = childIds;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Long> getChildIds() {
        return childIds;
    }

    public void setChildIds(List<Long> childIds) {
        this.childIds = childIds;
    }
}
