package com.datacenter.service.rowService;

import com.datacenter.da.entity.DataCenter;
import com.datacenter.da.entity.Row;
import com.datacenter.da.repository.DataCenterRepository;
import com.datacenter.da.repository.RowRepository;
import com.datacenter.dto.RowDto;

import com.datacenter.mapper.RowMapper;
import com.datacenter.service.rowService.RowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RowServiceImpl implements RowService {

    private final RowRepository rowRepository;
    private final DataCenterRepository dataCenterRepository;
    private final RowMapper rowMapper;

    public RowServiceImpl(RowRepository rowRepository, DataCenterRepository dataCenterRepository, RowMapper rowMapper) {
        this.rowRepository = rowRepository;
        this.dataCenterRepository = dataCenterRepository;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<RowDto> findAll() {
        return rowRepository.findAll().stream()
                .map(rowMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RowDto findById(Long id) {
        return rowRepository.findById(id)
                .map(rowMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Row not found with id " + id));
    }

    @Override
    public RowDto save(RowDto dto) {
        Row row = rowMapper.toEntity(dto);
        if (dto.getDataCenterId() != null) {
            DataCenter dc = dataCenterRepository.findById(dto.getDataCenterId())
                    .orElseThrow(() -> new RuntimeException("DataCenter not found with id " + dto.getDataCenterId()));
            row.setDataCenter(dc);
        }
        Row saved = rowRepository.save(row);
        return rowMapper.toDto(saved);
    }

    public RowDto update(Long id, RowDto dto) {
        Row existing = rowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Row not found with id " + id));
        existing.setLabel(dto.getLabel());  // اصلاح شده
        if (dto.getDataCenterId() != null) {
            DataCenter dc = dataCenterRepository.findById(dto.getDataCenterId())
                    .orElseThrow(() -> new RuntimeException("DataCenter not found with id " + dto.getDataCenterId()));
            existing.setDataCenter(dc);
        }
        Row updated = rowRepository.save(existing);
        return rowMapper.toDto(updated);
    }


    @Override
    public void delete(Long id) {
        rowRepository.deleteById(id);
    }
}
