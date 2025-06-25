package com.datacenter.mapper;

import com.datacenter.da.entity.AuditLog;
import com.datacenter.dto.AuditLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AuditLogMapper {

    AuditLogDto toDto(AuditLog entity);

    @Mapping(target = "id", ignore = true) // در صورت نیاز
    AuditLog toEntity(AuditLogDto dto);
}
