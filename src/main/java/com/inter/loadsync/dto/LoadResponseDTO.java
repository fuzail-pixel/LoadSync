package com.inter.loadsync.dto;

import com.inter.loadsync.entity.LoadStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoadResponseDTO {

    private UUID id;
    private String shipperId;

    private String loadingPoint;
    private String unloadingPoint;
    private LocalDateTime loadingDate;
    private LocalDateTime unloadingDate;

    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Double weight;
    private String comment;

    private LocalDateTime datePosted;
    private LoadStatus status;
}
