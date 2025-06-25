package com.datacenter.controller;

import com.datacenter.dto.PortDto;
import com.datacenter.facade.PortFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortController {

    public PortController(PortFacade portFacade) {
        this.portFacade = portFacade;
    }

    private final PortFacade portFacade;

    @GetMapping
    public ResponseEntity<List<PortDto>> getAll() {
        return ResponseEntity.ok(portFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(portFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<PortDto> create(@RequestBody PortDto dto) {
        return ResponseEntity.ok(portFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortDto> update(@PathVariable Long id, @RequestBody PortDto dto) {
        return ResponseEntity.ok(portFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        portFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
