package com.inter.loadsync.service;

import com.inter.loadsync.dto.LoadDTO;
import com.inter.loadsync.dto.LoadResponseDTO;

import java.util.List;
import java.util.UUID;

public interface LoadService {
    LoadResponseDTO createLoad(LoadDTO loadDTO);
    LoadResponseDTO getLoadById(UUID id);
    List<LoadResponseDTO> getAllLoads();
    LoadResponseDTO updateLoad(UUID id, LoadDTO loadDTO);
    void deleteLoad(UUID id);
}
