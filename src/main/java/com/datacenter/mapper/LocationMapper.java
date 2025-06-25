package com.datacenter.mapper;


import com.datacenter.da.entity.Location;
import com.datacenter.dto.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LocationMapper {


    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = ".", target = "childIds", qualifiedByName = "mapChildIds")
    LocationDto toDto(Location location);

    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    Location toEntity(LocationDto dto);

    @Named("mapChildIds")
    default List<Long> mapChildIds(Location location) {
        if (location.getChildren() == null) return null;
        return location.getChildren().stream()
                .map(Location::getId)
                .collect(Collectors.toList());
    }
}

