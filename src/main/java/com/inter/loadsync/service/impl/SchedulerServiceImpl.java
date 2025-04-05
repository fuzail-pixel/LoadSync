package com.inter.loadsync.service.impl;

import com.inter.loadsync.dto.SchedulerDTO;
import com.inter.loadsync.entity.Scheduler;
import com.inter.loadsync.repository.SchedulerRepository;
import com.inter.loadsync.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    private SchedulerDTO convertToDTO(Scheduler scheduler) {
        return new SchedulerDTO(
                scheduler.getId(),
                scheduler.getSchedulerName(),
                scheduler.getSchedulerType(),
                scheduler.getSchedulerLocation()
        );
    }

    private Scheduler convertToEntity(SchedulerDTO dto) {
        return new Scheduler(
                dto.getId(),
                dto.getSchedulerName(),
                dto.getSchedulerType(),
                dto.getSchedulerLocation()
        );
    }

    @Override
    public List<SchedulerDTO> getAllSchedulers() {
        return schedulerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SchedulerDTO getSchedulerById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scheduler not found with id: " + id));
        return convertToDTO(scheduler);
    }

    @Override
    public void deleteScheduler(Long id) {
        schedulerRepository.deleteById(id);
    }

    @Override
    public void saveSchedulers(List<SchedulerDTO> schedulers) {
        List<Scheduler> entities = schedulers.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        schedulerRepository.saveAll(entities);
    }
}
