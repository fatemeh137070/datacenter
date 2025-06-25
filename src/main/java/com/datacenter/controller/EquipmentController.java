package com.datacenter.controller;

import com.datacenter.dto.EquipmentDto;
import com.datacenter.facade.EquipmentFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentFacade facade;

    public EquipmentController(EquipmentFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentDto>> getAll() {
        return ResponseEntity.ok(facade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDto> getById(@PathVariable Long id) {
        return facade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EquipmentDto> save(@RequestBody EquipmentDto dto) {
        return ResponseEntity.ok(facade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentDto> update(@PathVariable Long id, @RequestBody EquipmentDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(facade.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}

