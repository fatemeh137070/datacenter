package com.datacenter.mapper;

import com.datacenter.da.entity.Rack;
import com.datacenter.dto.RackDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RackMapper {
    @Mapping(source = "row.id", target = "rowId")
    RackDto toDto(Rack rack);

    @Mapping(source = "rowId", target = "row.id")
    Rack toEntity(RackDto dto);
}
