package com.datacenter.controller;

import com.datacenter.dto.RowDto;
import com.datacenter.facade.RowFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rows")
public class RowController {

    private final RowFacade rowFacade;

    public RowController(RowFacade rowFacade) {
        this.rowFacade = rowFacade;
    }

    @GetMapping
    public ResponseEntity<List<RowDto>> getAll() {
        return ResponseEntity.ok(rowFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RowDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rowFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<RowDto> create(@RequestBody RowDto dto) {
        return ResponseEntity.ok(rowFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RowDto> update(@PathVariable Long id, @RequestBody RowDto dto) {
        return ResponseEntity.ok(rowFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rowFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
