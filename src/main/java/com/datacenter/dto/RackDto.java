package com.datacenter.dto;

import lombok.Data;

@Data
public class RackDto {
    private Long id;
    private String label;
    private Long rowId;

    public RackDto() {
    }

    public RackDto(Long id, String label, Long rowId) {
        this.id = id;
        this.label = label;
        this.rowId = rowId;
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

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }
}
