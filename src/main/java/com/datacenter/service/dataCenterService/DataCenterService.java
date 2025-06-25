package com.datacenter.service.dataCenterService;

import com.datacenter.da.entity.DataCenter;

import java.util.List;
import java.util.Optional;

public interface DataCenterService {
    List<DataCenter> findAll();
    Optional<DataCenter> findById(Long id);
    DataCenter save(DataCenter dataCenter);
    DataCenter update(DataCenter dataCenter);
    void delete(Long id);
}