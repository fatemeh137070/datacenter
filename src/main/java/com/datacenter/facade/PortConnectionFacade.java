package com.datacenter.facade;

import com.datacenter.dto.PortConnectionDto;
import com.datacenter.service.portConnectionService.PortConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PortConnectionFacade {
    public PortConnectionFacade(PortConnectionService service) {
        this.service = service;
    }

    private final PortConnectionService service;

    public List<PortConnectionDto> findAll() {
        return service.findAll();
    }

    public Optional<PortConnectionDto> findById(Long id) {
        return service.findById(id);
    }

    public PortConnectionDto save(PortConnectionDto dto) {
        return service.save(dto);
    }

    public PortConnectionDto update(Long id, PortConnectionDto dto) {
        return service.update(id, dto);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
