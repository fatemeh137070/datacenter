package com.datacenter.dto;


import lombok.Data;

@Data
public class PortConnectionDto {
    private Long id;
    private Long sourcePortId;
    private Long destinationPortId;
    private Long patchPanelId; // nullable

    public PortConnectionDto() {
    }

    public PortConnectionDto(Long id, Long sourcePortId, Long destinationPortId, Long patchPanelId) {
        this.id = id;
        this.sourcePortId = sourcePortId;
        this.destinationPortId = destinationPortId;
        this.patchPanelId = patchPanelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourcePortId() {
        return sourcePortId;
    }

    public void setSourcePortId(Long sourcePortId) {
        this.sourcePortId = sourcePortId;
    }

    public Long getDestinationPortId() {
        return destinationPortId;
    }

    public void setDestinationPortId(Long destinationPortId) {
        this.destinationPortId = destinationPortId;
    }

    public Long getPatchPanelId() {
        return patchPanelId;
    }

    public void setPatchPanelId(Long patchPanelId) {
        this.patchPanelId = patchPanelId;
    }
}
