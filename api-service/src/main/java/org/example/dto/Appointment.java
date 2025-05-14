package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Long id;
    private LocalDateTime appointmentDate;
    private String doctor;
    private String notes;
    private String services;
    private String complaints;
    private boolean visited;
    private Double amount;
    private String clientPhone;
}
