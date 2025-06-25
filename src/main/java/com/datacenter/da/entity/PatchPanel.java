package com.datacenter.da.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PatchPanel extends Equipment {
    private int portCount;
}