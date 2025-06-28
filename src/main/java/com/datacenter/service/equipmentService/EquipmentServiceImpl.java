package com.datacenter.service.equipmentService;


import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.Port;
import com.datacenter.da.repository.EquipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }



    @Override
    public Equipment update(Equipment equipment) {
        {
            Optional<Equipment> existingOpt = equipmentRepository.findById(equipment.getId());
            if (existingOpt.isEmpty()) {
                throw new EntityNotFoundException("Equipment not found");
            }
            Equipment existing = existingOpt.get();
            existing.setModel(equipment.getModel());
            existing.setSizeInUnits(equipment.getSizeInUnits());
            existing.setPorts(equipment.getPorts());
            existing.setType(equipment.getType());
            existing.setPortCount(equipment.getPortCount());

            // مدیریت درست orphanRemoval
            existing.getPorts().clear();
            if (equipment.getPorts() != null) {
                for (Port port : equipment.getPorts()) {
                    port.setEquipment(existing); // 🔁 تنظیم دوباره سمت معکوس
                }
                existing.getPorts().addAll(equipment.getPorts());
            }
            return equipmentRepository.save(existing);

        }
    }


        @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}