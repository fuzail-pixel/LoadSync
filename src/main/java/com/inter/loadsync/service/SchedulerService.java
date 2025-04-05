package com.inter.loadsync.service;

import com.inter.loadsync.dto.SchedulerDTO;

import java.util.List;

public interface SchedulerService {
    List<SchedulerDTO> getAllSchedulers();
    SchedulerDTO getSchedulerById(Long id);
    void deleteScheduler(Long id);
    void saveSchedulers(List<SchedulerDTO> schedulers);
}
