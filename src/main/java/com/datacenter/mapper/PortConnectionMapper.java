package com.datacenter.mapper;

import com.datacenter.da.entity.PortConnection;
import com.datacenter.dto.PortConnectionDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PortConnectionMapper {

    @Mapping(source = "source.id", target = "sourcePortId")
    @Mapping(source = "destination.id", target = "destinationPortId")
    @Mapping(source = "throughPatchPanel.id", target = "patchPanelId")
    PortConnectionDto toDto(PortConnection entity);

    @Mapping(target = "source", ignore = true)
    @Mapping(target = "destination", ignore = true)
    @Mapping(target = "throughPatchPanel", ignore = true)
    PortConnection toEntity(PortConnectionDto dto);
}
