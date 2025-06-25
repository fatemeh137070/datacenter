// PatchPanelService.java
package com.datacenter.service.patchPanelService;

import com.datacenter.dto.PatchPanelDto;

import java.util.List;
import java.util.Optional;

public interface PatchPanelService {
    List<PatchPanelDto> findAll();
    Optional<PatchPanelDto> findById(Long id);
    PatchPanelDto save(PatchPanelDto dto);
    PatchPanelDto update(Long id, PatchPanelDto dto);
    void delete(Long id);
}
