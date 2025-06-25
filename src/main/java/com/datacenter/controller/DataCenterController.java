package com.datacenter.controller;

import com.datacenter.da.entity.DataCenter;
import com.datacenter.dto.DataCenterDto;
import com.datacenter.facade.DataCenterFacade;
import com.datacenter.mapper.DataCenterMapper;
import com.datacenter.service.dataCenterService.DataCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datacenters")
public class DataCenterController {

    private final DataCenterFacade dataCenterFacade;

    public DataCenterController(DataCenterFacade dataCenterFacade) {
        this.dataCenterFacade = dataCenterFacade;
    }

    @GetMapping
    public ResponseEntity<List<DataCenterDto>> getAll() {
        return ResponseEntity.ok(dataCenterFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataCenterDto> getById(@PathVariable Long id) {
        return dataCenterFacade.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DataCenterDto> create(@RequestBody DataCenterDto dto) {
        return ResponseEntity.ok(dataCenterFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataCenterDto> update(@PathVariable Long id, @RequestBody DataCenterDto dto) {
        return ResponseEntity.ok(dataCenterFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dataCenterFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}