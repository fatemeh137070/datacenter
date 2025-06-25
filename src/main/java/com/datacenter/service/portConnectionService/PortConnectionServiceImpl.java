package com.datacenter.service.portConnectionService;

import com.datacenter.da.entity.*;
import com.datacenter.da.repository.*;
import com.datacenter.dto.PortConnectionDto;
import com.datacenter.mapper.PortConnectionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PortConnectionServiceImpl implements PortConnectionService {

    private final PortConnectionRepository portConnectionRepository;
    private final PortRepository portRepository;
    private final PatchPanelRepository patchPanelRepository;
    private final PortConnectionMapper portConnectionMapper;

    public PortConnectionServiceImpl(PortConnectionRepository portConnectionRepository, PortRepository portRepository, PatchPanelRepository patchPanelRepository, PortConnectionMapper portConnectionMapper) {
        this.portConnectionRepository = portConnectionRepository;
        this.portRepository = portRepository;
        this.patchPanelRepository = patchPanelRepository;
        this.portConnectionMapper = portConnectionMapper;
    }

    @Override
    public List<PortConnectionDto> findAll() {
        return portConnectionRepository.findAll()
                .stream()
                .map(portConnectionMapper::toDto)
                .toList();
    }

    @Override
    public Optional<PortConnectionDto> findById(Long id) {
        return portConnectionRepository.findById(id)
                .map(portConnectionMapper::toDto);
    }

    @Override
    public PortConnectionDto save(PortConnectionDto dto) {
        PortConnection entity = new PortConnection();

        entity.setSource(portRepository.findById(dto.getSourcePortId()).orElse(null));
        entity.setDestination(portRepository.findById(dto.getDestinationPortId()).orElse(null));
        if (dto.getPatchPanelId() != null) {
            entity.setThroughPatchPanel(patchPanelRepository.findById(dto.getPatchPanelId()).orElse(null));
        }

        return portConnectionMapper.toDto(portConnectionRepository.save(entity));
    }

    @Override
    public PortConnectionDto update(Long id, PortConnectionDto dto) {
        PortConnection entity = portConnectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PortConnection not found"));

        entity.setSource(portRepository.findById(dto.getSourcePortId()).orElse(null));
        entity.setDestination(portRepository.findById(dto.getDestinationPortId()).orElse(null));
        if (dto.getPatchPanelId() != null) {
            entity.setThroughPatchPanel(patchPanelRepository.findById(dto.getPatchPanelId()).orElse(null));
        } else {
            entity.setThroughPatchPanel(null);
        }

        return portConnectionMapper.toDto(portConnectionRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        portConnectionRepository.deleteById(id);
    }
}
