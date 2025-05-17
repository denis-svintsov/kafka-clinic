package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.example.kafkaProducer.ClientKafkaProducer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientKafkaProducer clientKafkaProducer;

    public void add(Client client) {
        clientKafkaProducer.send("client-topic", client);
    }
}
