package com.datacenter.service.serverService;

import com.datacenter.da.entity.Server;
import com.datacenter.da.repository.ServerRepository;
import com.datacenter.dto.ServerDto;
import com.datacenter.mapper.ServerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;
    private final ServerMapper serverMapper;

    public ServerServiceImpl(ServerRepository serverRepository, ServerMapper serverMapper) {
        this.serverRepository = serverRepository;
        this.serverMapper = serverMapper;
    }

    @Override
    public List<ServerDto> findAll() {
        return serverRepository.findAll()
                .stream()
                .map(serverMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ServerDto> findById(Long id) {
        return serverRepository.findById(id).map(serverMapper::toDto);
    }

    @Override
    public ServerDto save(ServerDto dto) {
        Server server = serverMapper.toEntity(dto);
        return serverMapper.toDto(serverRepository.save(server));
    }

    @Override
    public ServerDto update(Long id, ServerDto dto) {
        Server existing = serverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Server not found"));
        existing.setCpu(dto.getCpu());
        existing.setRamGb(dto.getRamGb());
        existing.setStorageGb(dto.getStorageGb());
        existing.setModel(dto.getModel());
        existing.setSizeInUnits(dto.getSizeInUnits());
        existing.setPortCount(dto.getPortCount());
        existing.setType(dto.getType());

        return serverMapper.toDto(serverRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        serverRepository.deleteById(id);
    }
}
