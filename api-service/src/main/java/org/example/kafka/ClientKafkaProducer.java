package org.example.kafka;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientKafkaProducer {
    private final KafkaTemplate<String, Client> kafkaTemplate;

    public void send(String topic, Client client) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topic, key, client);
    }
}
