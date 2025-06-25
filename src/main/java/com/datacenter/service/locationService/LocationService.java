package com.datacenter.service.locationService;

import com.datacenter.dto.LocationDto;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<LocationDto> findAll();
    Optional<LocationDto> findById(Long id);
    LocationDto save(LocationDto dto);
    LocationDto update(Long id, LocationDto dto);
    void delete(Long id);
}
