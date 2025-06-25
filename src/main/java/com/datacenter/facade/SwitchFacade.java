// SwitchFacade.java
package com.datacenter.facade;

import com.datacenter.dto.SwitchDto;
import com.datacenter.service.switchService.SwitchService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SwitchFacade {

    private final SwitchService switchService;

    public SwitchFacade(SwitchService switchService) {
        this.switchService = switchService;
    }

    public List<SwitchDto> findAll() {
        return switchService.findAll();
    }

    public Optional<SwitchDto> findById(Long id) {
        return switchService.findById(id);
    }

    public SwitchDto save(SwitchDto dto) {
        return switchService.save(dto);
    }

    public SwitchDto update(Long id, SwitchDto dto) {
        return switchService.update(id, dto);
    }

    public void delete(Long id) {
        switchService.delete(id);
    }
}
