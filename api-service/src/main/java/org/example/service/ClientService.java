package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final KafkaTemplate<String, Client> kafkaTemplate;

    public void add(Client client) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send("client-topic", key, client);
    }
}
