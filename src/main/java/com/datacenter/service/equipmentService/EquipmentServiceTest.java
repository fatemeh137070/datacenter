//package com.datacenter.service.equipmentService;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.datacenter.da.entity.Switch;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@SpringBootTest
//class EquipmentServiceTest {
//
//    @Autowired
//    private EquipmentService service;
//
//    @Test
//    void shouldSaveAndFetchEquipment() {
//        Switch sw = new Switch();
//        sw.setModel("Cisco 24P");
//        sw.setPortCount(24);
//        sw.setSizeInUnits(1);
//
//        Equipment saved = service.save(sw);
//
//        assertNotNull(saved.getId());
//
//        Equipment fetched = service.findById(saved.getId()).orElse(null);
//
//        assertNotNull(fetched);
//        assertEquals("Cisco 24P", fetched.getModel());
//    }
//}
