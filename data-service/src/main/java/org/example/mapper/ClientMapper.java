package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.dto.Client;
import org.example.entity.AppointmentEntity;
import org.example.entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientMapper {
    private final AppointmentMapper appointmentMapper;

    public ClientEntity mapToEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setAddress(client.getAddress());
        clientEntity.setAge(client.getAge());
        clientEntity.setName(client.getName());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setSurname(client.getSurname());
        clientEntity.setPatronymic(client.getPatronymic());
        return clientEntity;
    }

    public Client mapToDto(ClientEntity clientEntity) {
        if (clientEntity == null) {
            return null;
        }

        Client client = new Client();
        client.setPhone(clientEntity.getPhone());
        client.setSurname(clientEntity.getSurname());
        client.setName(clientEntity.getName());
        client.setPatronymic(clientEntity.getPatronymic());
        client.setAge(clientEntity.getAge());
        client.setAddress(clientEntity.getAddress());
        client.setEmail(clientEntity.getEmail());

        // Если необходимо, можно преобразовать список AppointmentEntity в список Appointment.
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentEntity appointmentEntity : clientEntity.getAppointments()) {
            // Преобразуем каждое AppointmentEntity в DTO Appointment
            appointments.add(appointmentMapper.mapToDto(appointmentEntity));
        }
        client.setAppointments(appointments);

        return client;
    }

}
