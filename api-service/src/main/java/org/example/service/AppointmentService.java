package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final KafkaTemplate<String, Appointment> kafkaTemplate;

    public void add(Appointment appointment) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send("appointment-topic", key, appointment);
    }
}
