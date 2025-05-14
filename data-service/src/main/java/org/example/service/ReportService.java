package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.example.entity.ClientEntity;
import org.example.exception.NoSuchClientException;
import org.example.mapper.ClientMapper;
import org.example.repository.AppointmentRepository;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client getRecordsForClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        ClientEntity clientEntity = clientRepository.findById(phone)
                .orElseThrow(() -> new NoSuchClientException("Нет клиента с таким номером телефона."));
        return clientMapper.mapToDto(clientEntity);
    }

    public Double getAmountByMonth() {
        YearMonth lastMonth = YearMonth.now().minusMonths(1);
        LocalDateTime start = lastMonth.atDay(1).atStartOfDay();
        LocalDateTime end = lastMonth.atEndOfMonth().plusDays(1).atStartOfDay();

        return appointmentRepository.sumVisitedAmountForDateRange(start, end);
    }

    public Double getAmountByClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        return appointmentRepository.sumAmountForClientWithVisitedTrue(phone);
    }

    public long getCountPlannedRecords() {
        return appointmentRepository.countByAppointmentDateAfter(LocalDateTime.now());
    }

    public long getVisitedRecordsByDate(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.countByVisitedIsTrueAndAppointmentDateBetween(start, end);
    }
}
