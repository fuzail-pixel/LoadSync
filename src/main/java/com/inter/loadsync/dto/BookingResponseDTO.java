package com.inter.loadsync.dto;

import com.inter.loadsync.entity.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class BookingResponseDTO {
    private UUID id;
    private UUID loadId;
    private String transporterId;
    private Double proposedRate;
    private String comment;
    private BookingStatus status;
    private LocalDateTime requestedAt;
}
