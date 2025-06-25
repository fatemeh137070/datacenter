
package com.datacenter.service.patchPanelService;

import com.datacenter.da.entity.PatchPanel;
import com.datacenter.da.repository.PatchPanelRepository;
import com.datacenter.dto.PatchPanelDto;
import com.datacenter.mapper.PatchPanelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PatchPanelServiceImpl implements PatchPanelService {

    private final PatchPanelRepository patchPanelRepository;
    private final PatchPanelMapper patchPanelMapper;

    public PatchPanelServiceImpl(PatchPanelRepository patchPanelRepository, PatchPanelMapper patchPanelMapper) {
        this.patchPanelRepository = patchPanelRepository;
        this.patchPanelMapper = patchPanelMapper;
    }

    @Override
    public List<PatchPanelDto> findAll() {
        return patchPanelRepository.findAll()
                .stream()
                .map(patchPanelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PatchPanelDto> findById(Long id) {
        return patchPanelRepository.findById(id)
                .map(patchPanelMapper::toDto);
    }

    @Override
    public PatchPanelDto save(PatchPanelDto dto) {
        PatchPanel entity = patchPanelMapper.toEntity(dto);
        PatchPanel saved = patchPanelRepository.save(entity);
        return patchPanelMapper.toDto(saved);
    }

    @Override
    public PatchPanelDto update(Long id, PatchPanelDto dto) {
        PatchPanel existing = patchPanelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PatchPanel not found with id " + id));

        existing.setModel(dto.getModel());
        existing.setSizeInUnits(dto.getSizeInUnits());
        existing.setPortCount(dto.getPortCount());
        existing.setType(dto.getType());

        PatchPanel updated = patchPanelRepository.save(existing);
        return patchPanelMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        patchPanelRepository.deleteById(id);
    }
}
