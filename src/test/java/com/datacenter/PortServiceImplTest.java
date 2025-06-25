package com.datacenter;

import com.datacenter.da.entity.Port;
import com.datacenter.da.repository.PortRepository;
import com.datacenter.dto.PortDto;
import com.datacenter.mapper.PortMapper;
import com.datacenter.service.enums.PortType;
import com.datacenter.service.portService.PortServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PortServiceImplTest {

    @Mock
    private PortRepository portRepository;

    @Mock
    private PortMapper portMapper;

    @InjectMocks
    private PortServiceImpl portService;

    @Test
    void testSavePort() {
        // داده ورودی (DTO)
        PortDto dto = new PortDto();
        dto.setNumber(1);
        dto.setPortType(PortType.valueOf("ETHERNET")); // فرضا رشته یا enum

        // موجودیت (Entity)
        Port entity = new Port();
        entity.setNumber(1);
        entity.setPortType(PortType.valueOf("ETHERNET"));

        // شبیه‌سازی متدهای مپر و ریپازیتوری
        when(portMapper.toEntity(any(PortDto.class))).thenReturn(entity);
        when(portRepository.save(any(Port.class))).thenReturn(entity);
        when(portMapper.toDto(any(Port.class))).thenReturn(dto);

        // صدا زدن متد سرویس
        PortDto result = portService.save(dto);

        System.out.println("Port Number: " + result.getNumber());

        // بررسی خروجی
        assertEquals(1, result.getNumber());
        verify(portRepository, times(1)).save(any(Port.class));
    }
}
