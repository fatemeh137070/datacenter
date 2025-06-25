package com.datacenter.service.auditLogService;

import com.datacenter.da.entity.AuditLog;
import com.datacenter.da.entity.User;
import com.datacenter.da.repository.AuditLogRepository;
import com.datacenter.dto.AuditLogDto;
import com.datacenter.mapper.AuditLogMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;
    private final AuditLogMapper auditLogMapper;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository, AuditLogMapper auditLogMapper) {
        this.auditLogRepository = auditLogRepository;
        this.auditLogMapper = auditLogMapper;
    }

    @Override
    public List<AuditLogDto> findAll() {
        return auditLogRepository.findAll()
                .stream()
                .map(auditLogMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuditLogDto> findById(Long id) {
        return auditLogRepository.findById(id)
                .map(auditLogMapper::toDto);
    }

    @Override
    public AuditLogDto save(AuditLogDto dto) {
        AuditLog entity = auditLogMapper.toEntity(dto);
        return auditLogMapper.toDto(auditLogRepository.save(entity));
    }

    @Override
    public AuditLogDto update(Long id, AuditLogDto dto) {
        AuditLog existing = auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuditLog not found with id " + id));
        existing.setAction(dto.getAction());
        existing.setTimestamp(dto.getTimestamp());
        // اگر خواستی user هم به‌روز کنی:
        existing.setUser(dto.getUser() != null ? new User() {{
            setId(dto.getUser().getId());
        }} : null);
        return auditLogMapper.toDto(auditLogRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        auditLogRepository.deleteById(id);
    }
}
