package com.datacenter;

import com.datacenter.da.entity.Row;
import com.datacenter.da.repository.RowRepository;
import com.datacenter.dto.RowDto;
import com.datacenter.mapper.RowMapper;
import com.datacenter.service.rowService.RowServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RowServiceImplTest {

    @Mock
    private RowRepository rowRepository;

    @Mock
    private RowMapper rowMapper;

    @InjectMocks
    private RowServiceImpl rowService;

    @Test
    void testSaveRow() {
        // ساختن ورودی
        RowDto dto = new RowDto();
        dto.setLabel("ردیف A");

        // ساختن entity معادل برای ذخیره
        Row entity = new Row();
        entity.setLabel("ردیف A");

        // وقتی mapper تبدیل می‌کند
        when(rowMapper.toEntity(any(RowDto.class))).thenReturn(entity);
        when(rowRepository.save(any(Row.class))).thenReturn(entity);
        when(rowMapper.toDto(any(Row.class))).thenReturn(dto);

        // اجرای متد تستی
        RowDto result = rowService.save(dto);

        System.out.println("Row Label: " + result.getLabel());

        // بررسی نتایج
        assertEquals("ردیف A", result.getLabel());
        verify(rowRepository, times(1)).save(any(Row.class));
    }
}
