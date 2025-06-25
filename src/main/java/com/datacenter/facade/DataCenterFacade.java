package com.datacenter.facade;

import com.datacenter.da.entity.DataCenter;
import com.datacenter.dto.DataCenterDto;
import com.datacenter.dto.UnitDto;
import com.datacenter.mapper.DataCenterMapper;
import com.datacenter.service.dataCenterService.DataCenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DataCenterFacade {

    private final DataCenterService dataCenterService;
    private final DataCenterMapper dataCenterMapper;

    public DataCenterFacade(DataCenterService dataCenterService, DataCenterMapper dataCenterMapper) {
        this.dataCenterService = dataCenterService;
        this.dataCenterMapper = dataCenterMapper;
    }

    public List<DataCenterDto> getAll() {
        return dataCenterService.findAll()
                .stream()
                .map(dataCenterMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<DataCenterDto> getById(Long id) {
        return dataCenterService.findById(id)
                .map(dataCenterMapper::toDto);
    }

    public DataCenterDto save(DataCenterDto dto) {
        DataCenter entity = dataCenterMapper.toEntity(dto);
        DataCenter saved = dataCenterService.save(entity);
        return dataCenterMapper.toDto(saved);
    }


    public DataCenterDto update(Long id, DataCenterDto dto) {
        dto.setId(id);
        var entity = dataCenterMapper.toEntity(dto);
        var updated = dataCenterService.update(entity);
        return dataCenterMapper.toDto(updated);
    }

    public void delete(Long id) {
        dataCenterService.delete(id);
    }

}