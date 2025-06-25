package com.datacenter.facade;

import com.datacenter.dto.RackDto;
import com.datacenter.service.rackService.RackService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RackFacade {

    public RackFacade(RackService rackService) {
        this.rackService = rackService;
    }

    private final RackService rackService;

    public List<RackDto> getAll() {
        return rackService.findAll();
    }

    public Optional<RackDto> getById(Long id) {
        return rackService.findById(id);
    }

    public RackDto create(RackDto dto) {
        return rackService.save(dto);
    }

    public RackDto update(Long id, RackDto dto) {
        return rackService.update(id, dto);
    }

    public void delete(Long id) {
        rackService.delete(id);
    }
}
