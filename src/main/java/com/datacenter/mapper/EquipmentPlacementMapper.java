package com.datacenter.mapper;

import com.datacenter.da.entity.EquipmentPlacement;
import com.datacenter.dto.EquipmentPlacementDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EquipmentPlacementMapper {

    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "rack.id", target = "rackId")
    EquipmentPlacementDto toDto(EquipmentPlacement entity);

    @Mapping(target = "equipment", ignore = true) // می‌تونیم در لایه‌ی فَساد تنظیم کنیم
    @Mapping(target = "rack", ignore = true)
    EquipmentPlacement toEntity(EquipmentPlacementDto dto);
}
