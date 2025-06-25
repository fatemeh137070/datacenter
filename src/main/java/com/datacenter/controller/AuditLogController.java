package com.datacenter.controller;

import com.datacenter.dto.AuditLogDto;
import com.datacenter.facade.AuditLogFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    public AuditLogController(AuditLogFacade auditLogFacade) {
        this.auditLogFacade = auditLogFacade;
    }

    private final AuditLogFacade auditLogFacade;

    @GetMapping
    public ResponseEntity<List<AuditLogDto>> getAll() {
        return ResponseEntity.ok(auditLogFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDto> getById(@PathVariable Long id) {
        return auditLogFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AuditLogDto> create(@RequestBody AuditLogDto dto) {
        return ResponseEntity.ok(auditLogFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLogDto> update(@PathVariable Long id, @RequestBody AuditLogDto dto) {
        return ResponseEntity.ok(auditLogFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        auditLogFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
