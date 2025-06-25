package com.datacenter.mapper;

import com.datacenter.da.entity.Server;
import com.datacenter.dto.ServerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    ServerDto toDto(Server entity);
    Server toEntity(ServerDto dto);
}
