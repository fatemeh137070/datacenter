package com.datacenter.dto;

import lombok.Data;

@Data
public class RowDto {
    private Long id;
    private String label;
    private Long dataCenterId;

    public RowDto() {
    }

    public RowDto(Long id, String label, Long dataCenterId) {
        this.id = id;
        this.label = label;
        this.dataCenterId = dataCenterId;
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

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }
}
