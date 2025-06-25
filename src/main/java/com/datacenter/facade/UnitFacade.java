package com.datacenter.facade;

import com.datacenter.dto.UnitDto;
import com.datacenter.service.unitService.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UnitFacade {

    public UnitFacade(UnitService unitService) {
        this.unitService = unitService;
    }

    private final UnitService unitService;

    public List<UnitDto> findAll() {
        return unitService.findAll();
    }

    public Optional<UnitDto> findById(Long id) {
        return unitService.findById(id);
    }

    public UnitDto save(UnitDto dto) {
        return unitService.save(dto);
    }

    public UnitDto update(Long id, UnitDto dto) {
        return unitService.update(id, dto);
    }

    public void delete(Long id) {
        unitService.delete(id);
    }
}
