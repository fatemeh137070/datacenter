// SwitchMapper.java
package com.datacenter.mapper;

import com.datacenter.da.entity.Switch;
import com.datacenter.dto.SwitchDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SwitchMapper {
    SwitchDto toDto(Switch entity);
    Switch toEntity(SwitchDto dto);
}
