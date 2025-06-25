package com.datacenter.facade;

import com.datacenter.dto.PortDto;
import com.datacenter.service.portService.PortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PortFacade {

    private final PortService portService;

    public PortFacade(PortService portService) {
        this.portService = portService;
    }

    public List<PortDto> findAll() {
        return portService.findAll();
    }

    public PortDto findById(Long id) {
        return portService.findById(id);
    }

    public PortDto save(PortDto dto) {
        return portService.save(dto);
    }

    public PortDto update(Long id, PortDto dto) {
        return portService.update(id, dto);
    }

    public void delete(Long id) {
        portService.delete(id);
    }
}
