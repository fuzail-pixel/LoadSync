package com.inter.loadsync.repository;

import com.inter.loadsync.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
}
