package com.datacenter.service.dataCenterService;


import com.datacenter.da.entity.DataCenter;
import com.datacenter.da.repository.DataCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataCenterServiceImpl implements DataCenterService {

    private final DataCenterRepository repository;

    public DataCenterServiceImpl(DataCenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DataCenter> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DataCenter> findById(Long id) {
        return repository.findById(id);
    }

    public DataCenter save(DataCenter dataCenter) {
        return repository.save(dataCenter);
    }

    @Override
    public DataCenter update(DataCenter dataCenter) {
        return repository.save(dataCenter);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
