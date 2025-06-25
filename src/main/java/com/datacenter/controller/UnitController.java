package com.datacenter.controller;

import com.datacenter.dto.UnitDto;
import com.datacenter.facade.UnitFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    private final UnitFacade unitFacade;

    public UnitController(UnitFacade unitFacade) {
        this.unitFacade = unitFacade;
    }

    @GetMapping
    public ResponseEntity<List<UnitDto>> getAll() {
        return ResponseEntity.ok(unitFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> getById(@PathVariable Long id) {
        return unitFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UnitDto> create(@RequestBody UnitDto dto) {
        return ResponseEntity.ok(unitFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDto> update(@PathVariable Long id, @RequestBody UnitDto dto) {
        return ResponseEntity.ok(unitFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        unitFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
