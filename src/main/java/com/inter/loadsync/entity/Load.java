package com.inter.loadsync.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Load {

    @Id
    @GeneratedValue
    private UUID id;

    private String shipperId;

    @Embedded
    private Facility facility;

    private String productType;

    private String truckType;

    private Integer noOfTrucks;

    private Double weight;

    private String comment;

    private LocalDateTime datePosted;

    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.POSTED;
}
