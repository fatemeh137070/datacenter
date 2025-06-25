package com.datacenter.factory.locationFactory;

import com.datacenter.da.entity.Location;
import com.datacenter.dto.LocationDto;
import com.datacenter.da.repository.LocationRepository;

public class LocationFactory {

    private LocationFactory() {
    }

    public static Location fromDto(LocationDto dto, LocationRepository repository) {
        Location location = new Location();
        location.setName(dto.getName());

        if (dto.getParentId() != null) {
            repository.findById(dto.getParentId()).ifPresent(location::setParent);
        }

        return location;
    }

    public static void updateFromDto(Location location, LocationDto dto, LocationRepository repository) {
        location.setName(dto.getName());

        if (dto.getParentId() != null) {
            location.setParent(repository.findById(dto.getParentId()).orElse(null));
        } else {
            location.setParent(null);
        }
    }
}
