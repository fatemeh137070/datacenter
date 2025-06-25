// PatchPanelFacade.java
package com.datacenter.facade;

import com.datacenter.dto.PatchPanelDto;
import com.datacenter.service.patchPanelService.PatchPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatchPanelFacade {

    private final PatchPanelService patchPanelService;

    public PatchPanelFacade(PatchPanelService patchPanelService) {
        this.patchPanelService = patchPanelService;
    }

    public List<PatchPanelDto> findAll() {
        return patchPanelService.findAll();
    }

    public Optional<PatchPanelDto> findById(Long id) {
        return patchPanelService.findById(id);
    }

    public PatchPanelDto save(PatchPanelDto dto) {
        return patchPanelService.save(dto);
    }

    public PatchPanelDto update(Long id, PatchPanelDto dto) {
        return patchPanelService.update(id, dto);
    }

    public void delete(Long id) {
        patchPanelService.delete(id);
    }
}
