package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.kafkaProducer.AppointmentKafkaProducer;
import org.example.kafkaProducer.ConfirmAppointmentKafkaProducer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final SenderGetRequest senderGetRequest;
    private final AppointmentKafkaProducer kafkaProducer;
    private final ConfirmAppointmentKafkaProducer confirmAppointmentKafkaProducer;

    public void add(Appointment appointment) {
        appointment.setVisited(false);
        kafkaProducer.send("appointment-topic", appointment);
    }

    public void setVisited(Long id) {
        confirmAppointmentKafkaProducer.send("appointment-confirm-topic", id);
    }
}
