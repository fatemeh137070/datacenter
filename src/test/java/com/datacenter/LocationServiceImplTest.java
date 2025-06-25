package com.datacenter;

import com.datacenter.da.entity.Location;
import com.datacenter.da.repository.LocationRepository;
import com.datacenter.dto.LocationDto;
import com.datacenter.mapper.LocationMapper;
import com.datacenter.service.locationService.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

    @Mock
    private LocationRepository locationRepository;
    @Mock
    private LocationMapper locationMapper;

    @InjectMocks
    private LocationServiceImpl locationService;

    @Test
    void testSaveLocation() {
        LocationDto dto = new LocationDto();
        dto.setName("تهران");

        Location entity = new Location();
        entity.setName("تهران");

        when(locationRepository.save(any(Location.class))).thenReturn(entity);
        when(locationMapper.toDto(any(Location.class))).thenReturn(dto);

        LocationDto result = locationService.save(dto);

        System.out.println("Test Result Location Name: " + result.getName());  // این خط اضافه شده

        assertEquals("تهران", result.getName());
        verify(locationRepository, times(1)).save(any(Location.class));
    }
}
