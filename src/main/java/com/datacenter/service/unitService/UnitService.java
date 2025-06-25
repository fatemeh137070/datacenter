package com.datacenter.service.unitService;

import com.datacenter.dto.UnitDto;

import java.util.List;
import java.util.Optional;

public interface UnitService {

    List<UnitDto> findAll();

    Optional<UnitDto> findById(Long id);

    UnitDto save(UnitDto dto);

    UnitDto update(Long id, UnitDto dto);

    void delete(Long id);
}
