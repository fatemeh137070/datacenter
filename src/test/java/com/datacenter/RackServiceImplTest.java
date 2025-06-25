package com.datacenter;

import com.datacenter.da.entity.Rack;
import com.datacenter.da.repository.RackRepository;
import com.datacenter.dto.RackDto;
import com.datacenter.mapper.RackMapper;
import com.datacenter.service.rackService.RackServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RackServiceImplTest {

    @Mock
    private RackRepository rackRepository;

    @Mock
    private RackMapper rackMapper;

    @InjectMocks
    private RackServiceImpl rackService;

    @Test
    void testSaveRack() {
        // داده‌ی DTO ورودی
        RackDto dto = new RackDto();
        dto.setLabel("رک-101");

        // entity معادل
        Rack entity = new Rack();
        entity.setLabel("رک-101");

        // شبیه‌سازی رفتار Mapper و Repository
        when(rackMapper.toEntity(any(RackDto.class))).thenReturn(entity);
        when(rackRepository.save(any(Rack.class))).thenReturn(entity);
        when(rackMapper.toDto(any(Rack.class))).thenReturn(dto);

        // اجرای متد سرویس
        RackDto result = rackService.save(dto);

        System.out.println("Rack Label: " + result.getLabel());

        // اعتبارسنجی نتیجه
        assertEquals("رک-101", result.getLabel());
        verify(rackRepository, times(1)).save(any(Rack.class));
    }
}
