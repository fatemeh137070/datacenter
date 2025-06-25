package com.datacenter;

import com.datacenter.da.entity.DataCenter;
import com.datacenter.da.repository.DataCenterRepository;
import com.datacenter.dto.DataCenterDto;
import com.datacenter.mapper.DataCenterMapper;
import com.datacenter.service.dataCenterService.DataCenterServiceImpl;
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
class DataCenterServiceImplTest {

    @Mock
    private DataCenterRepository dataCenterRepository;

    @Mock
    private DataCenterMapper dataCenterMapper;

    @InjectMocks
    private DataCenterServiceImpl dataCenterService;

    @Test
    void testSaveDataCenter() {


        DataCenter entity = new DataCenter();
        entity.setName("مرکز داده تهران");


        // save entity
        when(dataCenterRepository.save(any(DataCenter.class))).thenReturn(entity);

        // map entity -> dto
        // call service method with correct argument
        DataCenter result = dataCenterService.save(entity);

        System.out.println("DataCenter Name: " + result.getName());

        assertEquals("مرکز داده تهران", result.getName());
        verify(dataCenterRepository, times(1)).save(any(DataCenter.class));
    }
}