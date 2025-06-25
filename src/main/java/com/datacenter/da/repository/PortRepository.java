package com.datacenter.da.repository;


import com.datacenter.da.entity.Equipment;
import com.datacenter.da.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortRepository extends JpaRepository<Port, Long> {
    List<Port> findByEquipment(Equipment equipment);
}
