package com.inter.loadsync.controller;

import com.inter.loadsync.dto.SchedulerDTO;
import com.inter.loadsync.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedulers")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping
    public ResponseEntity<List<SchedulerDTO>> getAllSchedulers() {
        return ResponseEntity.ok(schedulerService.getAllSchedulers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulerDTO> getSchedulerById(@PathVariable Long id) {
        return ResponseEntity.ok(schedulerService.getSchedulerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedulerById(@PathVariable Long id) {
        schedulerService.deleteScheduler(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadSchedulers(@RequestBody List<SchedulerDTO> schedulers) {
        schedulerService.saveSchedulers(schedulers);
        return ResponseEntity.ok("Schedulers uploaded successfully");
    }
}
