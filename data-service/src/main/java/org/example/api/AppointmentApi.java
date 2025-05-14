package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.dto.Client;
import org.example.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentApi {
    private final AppointmentService appointmentService;

    @GetMapping("/getRecordById")
    public ResponseEntity<Appointment> getRecordById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(appointmentService.findById(id));
    }
}
