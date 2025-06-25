package com.datacenter.mapper;

import com.datacenter.da.entity.Port;
import com.datacenter.dto.PortDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PortMapper {

    @Mapping(source = "equipment.id", target = "equipmentId")
    PortDto toDto(Port port);

    @Mapping(target = "equipment", ignore = true)  // Equipment را در سرویس ست میکنیم
    Port toEntity(PortDto dto);
}