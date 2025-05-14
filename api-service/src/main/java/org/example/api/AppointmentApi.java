package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentApi {
    private final AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Appointment appointment) {
        appointmentService.add(appointment);
        return ResponseEntity.ok("Сообщение отправлено в топик.");
    }
}
