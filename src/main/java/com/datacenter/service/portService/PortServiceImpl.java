package com.datacenter.service.portService;

import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.Port;
import com.datacenter.da.repository.EquipmentRepository;
import com.datacenter.da.repository.PortRepository;
import com.datacenter.dto.PortDto;
import com.datacenter.mapper.PortMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortServiceImpl implements PortService {

    private final PortRepository portRepository;
    private final EquipmentRepository equipmentRepository;
    private final PortMapper portMapper;

    public PortServiceImpl(PortRepository portRepository, EquipmentRepository equipmentRepository, PortMapper portMapper) {
        this.portRepository = portRepository;
        this.equipmentRepository = equipmentRepository;
        this.portMapper = portMapper;
    }

    public List<PortDto> findAll() {
        return portRepository.findAll()
                .stream()
                .map(portMapper::toDto)
                .toList();
    }

    public PortDto findById(Long id) {
        Port port = portRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Port not found with id " + id));
        return portMapper.toDto(port);
    }

    public PortDto save(PortDto dto) {
        Port port = portMapper.toEntity(dto);
        if (dto.getEquipmentId() != null) {
            Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                    .orElseThrow(() -> new RuntimeException("Equipment not found with id " + dto.getEquipmentId()));
            port.setEquipment(equipment);
        }
        Port saved = portRepository.save(port);
        return portMapper.toDto(saved);
    }

    public PortDto update(Long id, PortDto dto) {
        Port existingPort = portRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Port not found with id " + id));
        existingPort.setNumber(dto.getNumber());
        existingPort.setActive(dto.isActive());
        existingPort.setPortType(dto.getPortType());

        if (dto.getEquipmentId() != null) {
            Equipment equipment = equipmentRepository.findById(dto.getEquipmentId())
                    .orElseThrow(() -> new RuntimeException("Equipment not found with id " + dto.getEquipmentId()));
            existingPort.setEquipment(equipment);
        } else {
            existingPort.setEquipment(null);
        }

        Port updated = portRepository.save(existingPort);
        return portMapper.toDto(updated);
    }

    public void delete(Long id) {
        Port port = portRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Port not found with id " + id));
        portRepository.delete(port);
    }
}
