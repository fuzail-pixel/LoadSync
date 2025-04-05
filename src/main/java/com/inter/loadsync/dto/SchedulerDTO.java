package com.inter.loadsync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerDTO {
    private Long id;
    private String schedulerName;
    private String schedulerType;
    private String schedulerLocation;
}
