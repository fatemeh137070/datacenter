// SwitchController.java
package com.datacenter.controller;

import com.datacenter.dto.SwitchDto;
import com.datacenter.facade.SwitchFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/switches")
public class SwitchController {

    public SwitchController(SwitchFacade switchFacade) {
        this.switchFacade = switchFacade;
    }

    private final SwitchFacade switchFacade;

    @GetMapping
    public ResponseEntity<List<SwitchDto>> getAll() {
        return ResponseEntity.ok(switchFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SwitchDto> getById(@PathVariable Long id) {
        return switchFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SwitchDto> create(@RequestBody SwitchDto dto) {
        return ResponseEntity.ok(switchFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SwitchDto> update(@PathVariable Long id, @RequestBody SwitchDto dto) {
        return ResponseEntity.ok(switchFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        switchFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
