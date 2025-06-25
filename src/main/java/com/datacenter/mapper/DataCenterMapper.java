package com.datacenter.mapper;


import com.datacenter.da.entity.DataCenter;
import com.datacenter.dto.DataCenterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DataCenterMapper {
    DataCenterMapper INSTANCE = Mappers.getMapper(DataCenterMapper.class);

    @Mapping(source = "location.id", target = "locationId")
    DataCenterDto toDto(DataCenter dataCenter);

    @Mapping(source = "locationId", target = "location.id")
    DataCenter toEntity(DataCenterDto dto);
}
