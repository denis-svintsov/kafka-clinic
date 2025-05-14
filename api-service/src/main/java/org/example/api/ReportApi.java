package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.example.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportApi {
    private final ReportService reportService;

    @GetMapping("/getRecordsForClient")
    public ResponseEntity<Client> getRecordsForClient(@RequestParam("phone") String phone) {
        return ResponseEntity.ok(reportService.getRecordsForClient(phone));
    }

    @GetMapping("/getCountPlannedRecords")
    public ResponseEntity<Long> getCountPlannedRecords() {
        return ResponseEntity.ok(reportService.getCountPlannedRecords());
    }

    @GetMapping("/getVisitedRecordsByDate")
    public ResponseEntity<Long> getVisitedRecordsByDate(@RequestParam("startDate") LocalDateTime startDate, @RequestParam("endDate") LocalDateTime endDate) {
        return ResponseEntity.ok(reportService.getVisitedRecordsByDate(startDate, endDate));
    }

    @GetMapping("/getAmountByMonth")
    public ResponseEntity<Double> getAmountByMonth() {
        return ResponseEntity.ok(reportService.getAmountByMonth());
    }

    @GetMapping("/getAmountByClient")
    public ResponseEntity<Double> getAmountByClient(@RequestParam("phone") String phone) {
        return ResponseEntity.ok(reportService.getAmountByClient(phone));
    }
}
