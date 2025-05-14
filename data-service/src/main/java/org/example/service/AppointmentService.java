package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.entity.AppointmentEntity;
import org.example.entity.ClientEntity;
import org.example.exception.NoSuchAppointmentException;
import org.example.exception.NoSuchClientException;
import org.example.mapper.AppointmentMapper;
import org.example.repository.AppointmentRepository;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentEntity add(Appointment appointment) {
        return appointmentRepository.save(appointmentMapper.mapToEntity(appointment));
    }

    public Appointment findById(Long id) {
        return appointmentMapper.mapToDto(appointmentRepository.findById(id).orElseThrow(
                () ->  new NoSuchAppointmentException("Не найдена запись с таким id.")
        ));
    }

}
