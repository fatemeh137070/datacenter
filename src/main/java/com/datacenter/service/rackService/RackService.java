package com.datacenter.service.rackService;

import com.datacenter.dto.RackDto;

import java.util.List;
import java.util.Optional;

public interface RackService {
    List<RackDto> findAll();
    Optional<RackDto> findById(Long id);
    RackDto save(RackDto dto);
    RackDto update(Long id, RackDto dto);
    void delete(Long id);
}
