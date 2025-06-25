package com.datacenter.service.auditLogService;

import com.datacenter.dto.AuditLogDto;

import java.util.List;
import java.util.Optional;

public interface AuditLogService {
    List<AuditLogDto> findAll();
    Optional<AuditLogDto> findById(Long id);
    AuditLogDto save(AuditLogDto dto);
    AuditLogDto update(Long id, AuditLogDto dto);
    void delete(Long id);
}
