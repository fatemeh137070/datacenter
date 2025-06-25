package com.datacenter.facade;

import com.datacenter.dto.AuditLogDto;
import com.datacenter.service.auditLogService.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class AuditLogFacade {

    public AuditLogFacade(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    private final AuditLogService auditLogService;

    public List<AuditLogDto> findAll() {
        return auditLogService.findAll();
    }

    public Optional<AuditLogDto> findById(Long id) {
        return auditLogService.findById(id);
    }

    public AuditLogDto save(AuditLogDto dto) {
        return auditLogService.save(dto);
    }

    public AuditLogDto update(Long id, AuditLogDto dto) {
        return auditLogService.update(id, dto);
    }

    public void delete(Long id) {
        auditLogService.delete(id);
    }
}
