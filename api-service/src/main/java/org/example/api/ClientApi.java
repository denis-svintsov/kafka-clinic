package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.Client;
import org.example.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientApi {
    private final ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Client client) {
        clientService.add(client);
        return ResponseEntity.ok("Сообщение отправлено в топик.");
    }

}
