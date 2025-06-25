package com.datacenter.controller;

import com.datacenter.dto.EquipmentPlacementDto;
import com.datacenter.facade.EquipmentPlacementFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment-placements")
public class EquipmentPlacementController {

    public EquipmentPlacementController(EquipmentPlacementFacade facade) {
        this.facade = facade;
    }

    private final EquipmentPlacementFacade facade;

    @GetMapping
    public ResponseEntity<List<EquipmentPlacementDto>> getAll() {
        return ResponseEntity.ok(facade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentPlacementDto> getById(@PathVariable Long id) {
        return facade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EquipmentPlacementDto> create(@RequestBody EquipmentPlacementDto dto) {
        return ResponseEntity.ok(facade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentPlacementDto> update(@PathVariable Long id, @RequestBody @Valid EquipmentPlacementDto dto) {
        return ResponseEntity.ok(facade.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
