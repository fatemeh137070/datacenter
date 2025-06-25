package com.datacenter.mapper;

import com.datacenter.da.entity.Equipment;
import com.datacenter.dto.EquipmentDto;
import com.datacenter.factory.EquipmentFactory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = EquipmentFactory.class)
public interface EquipmentMapper {

    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "type", target = "type")
    EquipmentDto toDto(Equipment equipment);


    @Mapping(target = "ports", ignore = true)
    Equipment toEntity(EquipmentDto dto);

    @ObjectFactory
    default Equipment create(EquipmentDto dto) {
        return new EquipmentFactory().createEquipment(dto);
    }
}
