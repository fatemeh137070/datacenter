package com.datacenter.service.portConnectionService;

import com.datacenter.dto.PortConnectionDto;

import java.util.List;
import java.util.Optional;

public interface PortConnectionService {
    List<PortConnectionDto> findAll();
    Optional<PortConnectionDto> findById(Long id);
    PortConnectionDto save(PortConnectionDto dto);
    PortConnectionDto update(Long id, PortConnectionDto dto);
    void delete(Long id);
}
