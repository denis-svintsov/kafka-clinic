package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final SenderGetRequest senderGetRequest;

    public Client getRecordsForClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        return senderGetRequest.getRecordsForClient(phone);
    }

    public Double getAmountByMonth() {
        return senderGetRequest.getAmountByMonth();
    }

    public Double getAmountByClient(String phone) {
        if (phone != null && !phone.isEmpty() && phone.charAt(0) == ' ') {
            phone = "+" + phone.substring(1);
        }
        return senderGetRequest.getAmountByClient(phone);
    }

    public long getCountPlannedRecords() {
        return senderGetRequest.getCountPlannedRecords();
    }

    public long getVisitedRecordsByDate(LocalDateTime start, LocalDateTime end) {
        return senderGetRequest.getVisitedRecordsByDate(start, end);
    }
}
