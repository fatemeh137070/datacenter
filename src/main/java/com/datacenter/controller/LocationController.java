package com.datacenter.controller;

import com.datacenter.dto.LocationDto;
import com.datacenter.facade.LocationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    public LocationController(LocationFacade locationFacade) {
        this.locationFacade = locationFacade;
    }

    private final LocationFacade locationFacade;

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAll() {
        return ResponseEntity.ok(locationFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getById(@PathVariable Long id) {
        return locationFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocationDto> create(@RequestBody LocationDto dto) {
        return ResponseEntity.ok(locationFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDto> update(@PathVariable Long id, @RequestBody LocationDto dto) {
        return ResponseEntity.ok(locationFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
