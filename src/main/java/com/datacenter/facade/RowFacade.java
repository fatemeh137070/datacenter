package com.datacenter.facade;

import com.datacenter.dto.RowDto;
import com.datacenter.service.rowService.RowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class RowFacade {

    private final RowService rowService;

    public RowFacade(RowService rowService) {
        this.rowService = rowService;
    }

    public List<RowDto> findAll() {
        return rowService.findAll();
    }

    public RowDto findById(Long id) {
        return rowService.findById(id);
    }

    public RowDto save(RowDto dto) {
        return rowService.save(dto);
    }

    public RowDto update(Long id, RowDto dto) {
        return rowService.update(id, dto);
    }

    public void delete(Long id) {
        rowService.delete(id);
    }
}
