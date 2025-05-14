package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "notes")
    private String notes;

    @Column(name = "services")
    private String services;

    @Column(name = "complaints")
    private String complaints;

    @Column(name = "visited")
    private boolean visited;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_phone", referencedColumnName = "phone")
    @JsonBackReference
    private ClientEntity client;
}
