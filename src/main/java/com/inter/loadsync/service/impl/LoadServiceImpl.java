package com.inter.loadsync.service.impl;

import com.inter.loadsync.dto.LoadDTO;
import com.inter.loadsync.dto.LoadResponseDTO;
import com.inter.loadsync.entity.Facility;
import com.inter.loadsync.entity.Load;
import com.inter.loadsync.entity.LoadStatus;
import com.inter.loadsync.repository.LoadRepository;
import com.inter.loadsync.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl implements LoadService {

    private final LoadRepository loadRepository;

    @Override
    public LoadResponseDTO createLoad(LoadDTO dto) {
        Load load = Load.builder()
                .shipperId(dto.getShipperId())
                .facility(Facility.builder()
                        .loadingPoint(dto.getLoadingPoint())
                        .unloadingPoint(dto.getUnloadingPoint())
                        .loadingDate(dto.getLoadingDate())
                        .unloadingDate(dto.getUnloadingDate())
                        .build())
                .productType(dto.getProductType())
                .truckType(dto.getTruckType())
                .noOfTrucks(dto.getNoOfTrucks())
                .weight(dto.getWeight())
                .comment(dto.getComment())
                .datePosted(LocalDateTime.now())
                .status(LoadStatus.POSTED)
                .build();

        Load saved = loadRepository.save(load);
        return mapToResponseDTO(saved);
    }

    @Override
    public LoadResponseDTO getLoadById(UUID id) {
        Load load = loadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Load not found"));
        return mapToResponseDTO(load);
    }

    @Override
    public List<LoadResponseDTO> getAllLoads() {
        return loadRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoadResponseDTO updateLoad(UUID id, LoadDTO dto) {
        Load load = loadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Load not found"));

        load.setShipperId(dto.getShipperId());
        load.setFacility(Facility.builder()
                .loadingPoint(dto.getLoadingPoint())
                .unloadingPoint(dto.getUnloadingPoint())
                .loadingDate(dto.getLoadingDate())
                .unloadingDate(dto.getUnloadingDate())
                .build());
        load.setProductType(dto.getProductType());
        load.setTruckType(dto.getTruckType());
        load.setNoOfTrucks(dto.getNoOfTrucks());
        load.setWeight(dto.getWeight());
        load.setComment(dto.getComment());

        Load updated = loadRepository.save(load);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteLoad(UUID id) {
        loadRepository.deleteById(id);
    }

    private LoadResponseDTO mapToResponseDTO(Load load) {
        Facility f = load.getFacility();
        return LoadResponseDTO.builder()
                .id(load.getId())
                .shipperId(load.getShipperId())
                .loadingPoint(f.getLoadingPoint())
                .unloadingPoint(f.getUnloadingPoint())
                .loadingDate(f.getLoadingDate())
                .unloadingDate(f.getUnloadingDate())
                .productType(load.getProductType())
                .truckType(load.getTruckType())
                .noOfTrucks(load.getNoOfTrucks())
                .weight(load.getWeight())
                .comment(load.getComment())
                .datePosted(load.getDatePosted())
                .status(load.getStatus())
                .build();
    }
}
