package com.datacenter.controller;

import com.datacenter.dto.RackDto;
import com.datacenter.facade.RackFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/racks")
public class RackController {

    private final RackFacade rackFacade;

    public RackController(RackFacade rackFacade) {
        this.rackFacade = rackFacade;
    }

    @GetMapping
    public ResponseEntity<List<RackDto>> getAll() {
        return ResponseEntity.ok(rackFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RackDto> getById(@PathVariable Long id) {
        return rackFacade.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RackDto> create(@RequestBody RackDto dto) {
        return ResponseEntity.ok(rackFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RackDto> update(@PathVariable Long id, @RequestBody RackDto dto) {
        return ResponseEntity.ok(rackFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rackFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
