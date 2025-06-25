package com.datacenter.da.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class PortConnection {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Port source;

    @OneToOne
    private Port destination;

    @ManyToOne
    private PatchPanel throughPatchPanel; // optional

    public PortConnection() {
    }

    public PortConnection(Long id, Port source, Port destination, PatchPanel throughPatchPanel) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.throughPatchPanel = throughPatchPanel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Port getSource() {
        return source;
    }

    public void setSource(Port source) {
        this.source = source;
    }

    public Port getDestination() {
        return destination;
    }

    public void setDestination(Port destination) {
        this.destination = destination;
    }

    public PatchPanel getThroughPatchPanel() {
        return throughPatchPanel;
    }

    public void setThroughPatchPanel(PatchPanel throughPatchPanel) {
        this.throughPatchPanel = throughPatchPanel;
    }
}