package org.example.kafka;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentKafkaProducer {
    private final KafkaTemplate<String, Appointment> kafkaTemplate;

    public void send(String topic, Appointment appointment) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, key, appointment);
    }
}
