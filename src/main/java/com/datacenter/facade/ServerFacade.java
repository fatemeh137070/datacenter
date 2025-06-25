package com.datacenter.facade;

import com.datacenter.dto.ServerDto;
import com.datacenter.service.serverService.ServerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServerFacade {

    private final ServerService serverService;

    public ServerFacade(ServerService serverService) {
        this.serverService = serverService;
    }

    public List<ServerDto> findAll() {
        return serverService.findAll();
    }

    public Optional<ServerDto> findById(Long id) {
        return serverService.findById(id);
    }

    public ServerDto save(ServerDto dto) {
        return serverService.save(dto);
    }

    public ServerDto update(Long id, ServerDto dto) {
        return serverService.update(id, dto);
    }

    public void delete(Long id) {
        serverService.delete(id);
    }
}
