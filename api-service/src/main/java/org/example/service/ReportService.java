package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final GetRequest getRequest;

    public Client getRecordsForClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        return getRequest.getRecordsForClient(phone);
    }

    public Double getAmountByMonth() {
        return getRequest.getAmountByMonth();
    }

    public Double getAmountByClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        return getRequest.getAmountByClient(phone);
    }

    public long getCountPlannedRecords() {
        return getRequest.getCountPlannedRecords();
    }

    public long getVisitedRecordsByDate(LocalDateTime start, LocalDateTime end) {
        return getRequest.getVisitedRecordsByDate(start, end);
    }
}
