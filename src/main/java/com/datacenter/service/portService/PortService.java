package com.datacenter.service.portService;

import com.datacenter.da.entity.Port;
import com.datacenter.dto.PortDto;
import io.micrometer.common.KeyValues;

import java.util.List;
import java.util.Optional;

public interface PortService {

    List<PortDto> findAll();

    PortDto findById(Long id);

    PortDto save(PortDto dto);

    PortDto update(Long id, PortDto dto);

    void delete(Long id);
}
