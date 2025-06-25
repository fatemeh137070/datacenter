// SwitchService.java
package com.datacenter.service.switchService;

import com.datacenter.dto.SwitchDto;

import java.util.List;
import java.util.Optional;

public interface SwitchService {
    List<SwitchDto> findAll();
    Optional<SwitchDto> findById(Long id);
    SwitchDto save(SwitchDto dto);
    SwitchDto update(Long id, SwitchDto dto);
    void delete(Long id);
}
