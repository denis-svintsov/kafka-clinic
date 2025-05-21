package org.example.kafkaProducer;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmAppointmentKafkaProducer {
    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void send(String topic, Long id) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, key, id);
    }
}
