// PatchPanelDto.java
package com.datacenter.dto;

import com.datacenter.service.enums.EquipmentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatchPanelDto extends EquipmentDto {
    private int portCount;
}
