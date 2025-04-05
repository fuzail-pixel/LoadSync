package com.inter.loadsync.controller;

import com.inter.loadsync.dto.LoadDTO;
import com.inter.loadsync.dto.LoadResponseDTO;
import com.inter.loadsync.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loads")
@RequiredArgsConstructor
public class LoadController {

    private final LoadService loadService;

    @PostMapping
    public ResponseEntity<LoadResponseDTO> createLoad(@RequestBody LoadDTO loadDTO) {
        return ResponseEntity.ok(loadService.createLoad(loadDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadResponseDTO> getLoad(@PathVariable UUID id) {
        return ResponseEntity.ok(loadService.getLoadById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoadResponseDTO>> getAllLoads() {
        return ResponseEntity.ok(loadService.getAllLoads());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoadResponseDTO> updateLoad(@PathVariable UUID id, @RequestBody LoadDTO loadDTO) {
        return ResponseEntity.ok(loadService.updateLoad(id, loadDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID id) {
        loadService.deleteLoad(id);
        return ResponseEntity.noContent().build();
    }
}
