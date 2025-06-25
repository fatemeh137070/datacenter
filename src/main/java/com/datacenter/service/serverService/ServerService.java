package com.datacenter.service.serverService;

import com.datacenter.dto.ServerDto;

import java.util.List;
import java.util.Optional;

public interface ServerService {
    List<ServerDto> findAll();
    Optional<ServerDto> findById(Long id);
    ServerDto save(ServerDto dto);
    ServerDto update(Long id, ServerDto dto);
    void delete(Long id);
}
