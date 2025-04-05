package com.inter.loadsync.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoadDTO {

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
}
