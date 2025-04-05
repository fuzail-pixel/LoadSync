package com.inter.loadsync.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookingDTO {
    private UUID loadId;
    private String transporterId;
    private Double proposedRate;
    private String comment;
}
