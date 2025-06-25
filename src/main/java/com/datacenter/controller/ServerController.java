package com.datacenter.controller;

import com.datacenter.dto.ServerDto;
import com.datacenter.facade.ServerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerFacade serverFacade;

    public ServerController(ServerFacade serverFacade) {
        this.serverFacade = serverFacade;
    }

    @GetMapping
    public ResponseEntity<List<ServerDto>> getAll() {
        return ResponseEntity.ok(serverFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServerDto> getById(@PathVariable Long id) {
        return serverFacade.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServerDto> create(@RequestBody ServerDto dto) {
        return ResponseEntity.ok(serverFacade.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServerDto> update(@PathVariable Long id, @RequestBody ServerDto dto) {
        return ResponseEntity.ok(serverFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serverFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
