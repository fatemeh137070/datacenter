package com.datacenter.service.locationService;

import com.datacenter.da.entity.Location;
import com.datacenter.da.repository.LocationRepository;
import com.datacenter.dto.LocationDto;
import com.datacenter.factory.locationFactory.LocationFactory;
import com.datacenter.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<LocationDto> findAll() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toDto)
                .toList();
    }

    @Override
    public Optional<LocationDto> findById(Long id) {
        return locationRepository.findById(id)
                .map(locationMapper::toDto);
    }

    @Override
    public LocationDto save(LocationDto dto) {
        Location location = LocationFactory.fromDto(dto, locationRepository);
        return locationMapper.toDto(locationRepository.save(location));
    }

    @Override
    public LocationDto update(Long id, LocationDto dto) {
        Location existing = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id " + id));

        // تغییر اصلی اینجا: استفاده از Factory
        LocationFactory.updateFromDto(existing, dto, locationRepository);
        return locationMapper.toDto(locationRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
