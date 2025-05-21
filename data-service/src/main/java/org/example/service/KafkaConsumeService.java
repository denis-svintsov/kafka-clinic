package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.dto.Client;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumeService {
    private final ClientService clientService;
    private final AppointmentService appointmentService;

    @KafkaListener(
            topics = "client-topic",
            groupId = "client-consumer-group",
            containerFactory = "clientKafkaListenerContainerFactory"
    )
    public void listenClient(Client client) {
        System.out.println("Received client: " + client);
        clientService.add(client);
        System.out.println("Added to database");
    }

    @KafkaListener(
            topics = "appointment-topic",
            groupId = "appointment-consumer-group",
            containerFactory = "appointmentKafkaListenerContainerFactory"
    )
    public void listenAppointment(Appointment appointment) {
        System.out.println("Received appointment: " + appointment);
        appointmentService.add(appointment);
        System.out.println("Added to database");
    }

    @KafkaListener(
            topics = "appointment-confirm-topic",
            groupId = "appointment-confirm-consumer-group",
            containerFactory = "appointmentKafkaListenerContainerFactory"
    )
    public void listenConfirmAppointment(Long id) {
        System.out.println("Received id: " + id);
        appointmentService.confirm(id);
        System.out.println("Appointment confirmed.");
    }
}
