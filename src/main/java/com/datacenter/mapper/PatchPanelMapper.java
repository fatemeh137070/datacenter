// PatchPanelMapper.java
package com.datacenter.mapper;

import com.datacenter.da.entity.PatchPanel;
import com.datacenter.dto.PatchPanelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatchPanelMapper {
    PatchPanelDto toDto(PatchPanel entity);
    PatchPanel toEntity(PatchPanelDto dto);
}
