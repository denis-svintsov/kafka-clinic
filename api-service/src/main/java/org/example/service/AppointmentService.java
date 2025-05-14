package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final GetRequest getRequest;
    private final KafkaTemplate<String, Appointment> kafkaTemplate;

    public void add(Appointment appointment) {
        String key = UUID.randomUUID().toString();
        appointment.setVisited(false);
        kafkaTemplate.send("appointment-topic", key, appointment);
    }

    public void setVisited(Long id) {
        Appointment appointment = getRequest.getRecordById(id);
        appointment.setVisited(true);
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send("appointment-topic", key, appointment);
    }
}
