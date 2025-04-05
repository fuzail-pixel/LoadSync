package com.inter.loadsync.repository;

import com.inter.loadsync.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
}
