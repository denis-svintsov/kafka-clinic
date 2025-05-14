package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.example.entity.ClientEntity;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientEntity add(Client client) {
        return clientRepository.save(clientMapper.mapToEntity(client));
    }

}
