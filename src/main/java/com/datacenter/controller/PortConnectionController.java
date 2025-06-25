package com.datacenter.controller;

import com.datacenter.dto.PortConnectionDto;
import com.datacenter.facade.PortConnectionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/port-connections")
public class PortConnectionController {

    public PortConnectionController(PortConnectionFacade facade) {
        this.facade = facade;
    }

    private final PortConnectionFacade facade;

    @GetMapping
    public ResponseEntity<List<PortConnectionDto>> getAll() {
        return ResponseEntity.ok(facade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortConnectionDto> getById(@PathVariable Long id) {
        return facade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PortConnectionDto> create(@RequestBody PortConnectionDto dto) {
        return ResponseEntity.ok(facade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortConnectionDto> update(@PathVariable Long id, @RequestBody PortConnectionDto dto) {
        return ResponseEntity.ok(facade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
