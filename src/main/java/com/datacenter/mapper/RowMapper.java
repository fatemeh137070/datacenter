package com.datacenter.mapper;

import com.datacenter.da.entity.Row;
import com.datacenter.dto.RowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RowMapper {

    @Mapping(source = "dataCenter.id", target = "dataCenterId")
    RowDto toDto(Row row);

    @Mapping(source = "dataCenterId", target = "dataCenter.id")
    Row toEntity(RowDto dto);
}
