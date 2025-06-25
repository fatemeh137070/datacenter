// PatchPanelController.java
package com.datacenter.controller;

import com.datacenter.dto.PatchPanelDto;
import com.datacenter.facade.PatchPanelFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patchpanels")
public class PatchPanelController {

    public PatchPanelController(PatchPanelFacade patchPanelFacade) {
        this.patchPanelFacade = patchPanelFacade;
    }

    private final PatchPanelFacade patchPanelFacade;

    @GetMapping
    public ResponseEntity<List<PatchPanelDto>> getAll() {
        return ResponseEntity.ok(patchPanelFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatchPanelDto> getById(@PathVariable Long id) {
        return patchPanelFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PatchPanelDto> create(@RequestBody PatchPanelDto dto) {
        return ResponseEntity.ok(patchPanelFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatchPanelDto> update(@PathVariable Long id, @RequestBody PatchPanelDto dto) {
        return ResponseEntity.ok(patchPanelFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patchPanelFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
