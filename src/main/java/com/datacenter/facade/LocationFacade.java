package com.datacenter.facade;

import com.datacenter.dto.LocationDto;
import com.datacenter.service.locationService.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocationFacade {
    public LocationFacade(LocationService locationService) {
        this.locationService = locationService;
    }

    private final LocationService locationService;

    public List<LocationDto> findAll() {
        return locationService.findAll();
    }

    public Optional<LocationDto> findById(Long id) {
        return locationService.findById(id);
    }

    public LocationDto save(LocationDto dto) {
        return locationService.save(dto);
    }

    public LocationDto update(Long id, LocationDto dto) {
        return locationService.update(id, dto);
    }

    public void delete(Long id) {
        locationService.delete(id);
    }
}
