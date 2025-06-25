package com.datacenter.service.rowService;

import com.datacenter.dto.RowDto;

import java.util.List;

public interface RowService {

    List<RowDto> findAll();

    RowDto findById(Long id);

    RowDto save(RowDto dto);

    RowDto update(Long id, RowDto dto);

    void delete(Long id);
}
