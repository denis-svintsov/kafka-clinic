package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.entity.AppointmentEntity;
import org.example.entity.ClientEntity;
import org.example.exception.NoSuchClientException;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ClientRepository clientRepository;

    public AppointmentEntity mapToEntity(Appointment appointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        ClientEntity client = clientRepository.findById(appointment.getClientPhone())
                .orElseThrow(() -> new NoSuchClientException("Нет клиента с таким номером телефона."));
        if (appointment.getId() != null) {
            appointmentEntity.setId(appointment.getId());
        }
        appointmentEntity.setClient(client);
        appointmentEntity.setServices(appointment.getServices());
        appointmentEntity.setAppointmentDate(appointment.getAppointmentDate());
        appointmentEntity.setDoctor(appointment.getDoctor());
        appointmentEntity.setNotes(appointment.getNotes());
        appointmentEntity.setAmount(appointment.getAmount());
        appointmentEntity.setComplaints(appointment.getComplaints());
        appointmentEntity.setVisited(appointment.isVisited());
        return  appointmentEntity;
    }

    public Appointment mapToDto(AppointmentEntity appointmentEntity) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentEntity.getId());
        appointment.setAppointmentDate(appointmentEntity.getAppointmentDate());
        appointment.setDoctor(appointmentEntity.getDoctor());
        appointment.setNotes(appointmentEntity.getNotes());
        appointment.setServices(appointmentEntity.getServices());
        appointment.setComplaints(appointmentEntity.getComplaints());
        appointment.setVisited(appointmentEntity.isVisited());
        appointment.setAmount(appointmentEntity.getAmount());
        appointment.setClientPhone(appointmentEntity.getClient().getPhone());

        return appointment;
    }

}
