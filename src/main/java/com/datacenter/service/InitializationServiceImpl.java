//package com.datacenter.service;
//
//
//import com.datacenter.da.entity.*;
//import com.datacenter.da.repository.*;
//import com.datacenter.service.enums.PortType;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
//public class InitializationServiceImpl implements InitializationService {
//
//    private final LocationRepository locationRepository;
//    private final DataCenterRepository dataCenterRepository;
//    private final RowRepository rowRepository;
//    private final RackRepository rackRepository;
//    private final UnitRepository unitRepository;
//    private final EquipmentRepository equipmentRepository;
//    private final EquipmentPlacementRepository equipmentPlacementRepository;
//    private final PortRepository portRepository;
//    private final PortConnectionRepository portConnectionRepository;
//
//    private static final Map<String, List<String>> LOCATIONS = Map.of(
//        "ایران", List.of("تهران", "اصفهان", "فارس", "خراسان رضوی", "آذربایجان شرقی")
//    );
//
//    private final List<EquipmentBuilder> equipmentBuilders = List.of(
//            new SwitchBuilder(),
//            new PatchPanelBuilder(),
//            new ServerBuilder("Server-1U", 1, "Xeon", 32, 500, 5),
//            new ServerBuilder("Server-2U", 2, "Xeon", 64, 1000, 5),
//            new ServerBuilder("Server-4U", 4, "EPYC", 128, 2000, 2)
//    );
//
//    @PostConstruct
//    public void init() {
//        createSampleData();
//    }
//
//    @Override
//    public void createSampleData() {
//        for (Map.Entry<String, List<String>> entry : LOCATIONS.entrySet()) {
//            String countryName = entry.getKey();
//            List<String> provinces = entry.getValue();
//
//            Location country = new Location();
//            country.setName(countryName);
//            locationRepository.save(country);
//
//            for (String provinceName : provinces) {
//                Location province = new Location();
//                province.setName(provinceName);
//                province.setParent(country);
//                locationRepository.save(province);
//
//                // شهر و محله برای نمونه ساخته نمی‌شود مگر اینکه نیاز باشد.
//
//                DataCenter dataCenter = new DataCenter();
//                dataCenter.setName("مرکز داده - " + provinceName);
//                dataCenter.setLocation(province);
//                dataCenterRepository.save(dataCenter);
//
//                for (int r = 1; r <= 5; r++) {
//                    Row row = new Row();
//                    row.setLabel("ردیف-" + r);
//                    row.setDataCenter(dataCenter);
//                    rowRepository.save(row);
//
//                    for (int k = 1; k <= 10; k++) {
//                        Rack rack = new Rack();
//                        rack.setLabel("رک-" + k);
//                        rack.setRow(row);
//                        rackRepository.save(rack);
//
//                        for (int u = 1; u <= 42; u++) {
//                            Unit unit = new Unit();
//                            unit.setPosition(u);
//                            unit.setRack(rack);
//                            unitRepository.save(unit);
//                        }
//
//                        int unitCursor = 1;
//                        int portIndex = 0;
//                        Equipment patchPanel = null;
//                        Equipment switchDevice = null;
//
//                        for (EquipmentBuilder builder : equipmentBuilders) {
//                            for (int i = 0; i < builder.getCount(); i++) {
//                                Equipment equipment = builder.build();
//                                equipmentRepository.save(equipment);
//                                generatePortsForEquipment(equipment, builder.getPortCount());
//
//                                int position = builder instanceof SwitchBuilder ? 42 : builder instanceof PatchPanelBuilder ? 41 : unitCursor;
//                                placeEquipment(equipment, rack, position);
//
//                                if (builder instanceof SwitchBuilder) switchDevice = equipment;
//                                if (builder instanceof PatchPanelBuilder) patchPanel = equipment;
//                                if (builder instanceof ServerBuilder) {
//                                    unitCursor += builder.getUnitSize();
//                                    connectServerToSwitchViaPatchPanel((Server) equipment, (PatchPanel) patchPanel, (Switch) switchDevice, portIndex++);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private void generatePortsForEquipment(Equipment equipment, int count) {
//        for (int i = 1; i <= count; i++) {
//            Port port = new Port();
//            port.setNumber(i);
//            port.setPortType(PortType.ETHERNET);
//            port.setActive(true);
//            port.setEquipment(equipment);
//            portRepository.save(port);
//        }
//    }
//
//    private void placeEquipment(Equipment equipment, Rack rack, int startUnit) {
//        EquipmentPlacement placement = new EquipmentPlacement();
//        placement.setEquipment(equipment);
//        placement.setRack(rack);
//        placement.setStartUnit(startUnit);
//        placement.setSize(equipment.getSizeInUnits());
//        equipmentPlacementRepository.save(placement);
//    }
//
//    private void connectServerToSwitchViaPatchPanel(Server server, PatchPanel pp, Switch sw, int portIndex) {
//        List<Port> serverPorts = portRepository.findByEquipment(server);
//        List<Port> patchPorts = portRepository.findByEquipment(pp);
//        List<Port> switchPorts = portRepository.findByEquipment(sw);
//
//        if (serverPorts.isEmpty() || patchPorts.size() <= portIndex || switchPorts.size() <= portIndex) return;
//
//        PortConnection first = new PortConnection();
//        first.setSource(serverPorts.get(0));
//        first.setDestination(patchPorts.get(portIndex));
//        first.setThroughPatchPanel(null);
//        portConnectionRepository.save(first);
//
//        PortConnection second = new PortConnection();
//        second.setSource(patchPorts.get(portIndex));
//        second.setDestination(switchPorts.get(portIndex));
//        second.setThroughPatchPanel(pp);
//        portConnectionRepository.save(second);
//    }
//
//    private interface EquipmentBuilder {
//        Equipment build();
//        int getCount();
//        int getPortCount();
//        int getUnitSize();
//    }
//
//    private static class SwitchBuilder implements EquipmentBuilder {
//        public Equipment build() {
//            Switch sw = new Switch();
//            sw.setModel("Switch-24P");
//            sw.setSizeInUnits(1);
//            sw.setPortCount(24);
//            return sw;
//        }
//        public int getCount() { return 1; }
//        public int getPortCount() { return 24; }
//        public int getUnitSize() { return 1; }
//    }
//
//    private static class PatchPanelBuilder implements EquipmentBuilder {
//        public Equipment build() {
//            PatchPanel pp = new PatchPanel();
//            pp.setModel("PatchPanel-24P");
//            pp.setSizeInUnits(1);
//            pp.setPortCount(24);
//            return pp;
//        }
//        public int getCount() { return 1; }
//        public int getPortCount() { return 24; }
//        public int getUnitSize() { return 1; }
//    }
//
//    private static class ServerBuilder implements EquipmentBuilder {
//        private final String model;
//        private final int size;
//        private final String cpu;
//        private final int ram;
//        private final int storage;
//        private final int count;
//
//        public ServerBuilder(String model, int size, String cpu, int ram, int storage, int count) {
//            this.model = model;
//            this.size = size;
//            this.cpu = cpu;
//            this.ram = ram;
//            this.storage = storage;
//            this.count = count;
//        }
//
//        public Equipment build() {
//            Server s = new Server();
//            s.setModel(model);
//            s.setSizeInUnits(size);
//            s.setCpu(cpu);
//            s.setRamGb(ram);
//            s.setStorageGb(storage);
//            return s;
//        }
//
//        public int getCount() { return count; }
//        public int getPortCount() { return 4; }
//        public int getUnitSize() { return size; }
//    }
//}
