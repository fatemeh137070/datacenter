package com.datacenter.service.equipmentService;

import com.datacenter.da.entity.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> findAll();
    Optional<Equipment> findById(Long id);
    Equipment save(Equipment equipment);

     Equipment update(Equipment equipment) ;

    void delete(Long id);
}
