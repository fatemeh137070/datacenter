package com.datacenter.mapper.unitMapper;

import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.Unit;
import com.datacenter.dto.UnitDto;
import com.datacenter.factory.EquipmentFactory;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EquipmentFactory.class)
public abstract class UnitMapper {

    @Autowired
    protected EquipmentFactory equipmentFactory;

    @Mapping(source = "rack.id", target = "rackId")
    @Mapping(source = "equipment.id", target = "equipmentId")
    public abstract UnitDto toDto(Unit unit);

    @Mapping(source = "rackId", target = "rack.id")
    @Mapping(source = "equipmentId", target = "equipment", qualifiedByName = "equipmentFromId")
    public abstract Unit toEntity(UnitDto dto);

    @Named("equipmentFromId")
    protected Equipment equipmentFromId(Long equipmentId) {
        return equipmentFactory.createEquipmentById(equipmentId);
    }
}
