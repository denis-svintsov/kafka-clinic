package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Appointment;
import org.example.dto.Client;
import org.example.exception.HttpResponseException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SenderGetRequest {
    private final WebClient webClient;

    public Client getRecordsForClient(String phone) {
        String url = "http://data-service:8081/api/report/getRecordsForClient?phone=" + phone;

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Client.class)
                .block();
    }

    public Double getAmountByMonth() {
        String url = "http://data-service:8081/api/report/getAmountByMonth";

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Double.class)
                .block();
    }

    public Double getAmountByClient(String phone) {
        String url = "http://data-service:8081/api/report/getAmountByClient?phone=" + phone;

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Double.class)
                .block();
    }

    public Long getCountPlannedRecords() {
        String url = "http://data-service:8081/api/report/getCountPlannedRecords";

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Long.class)
                .block();
    }

    public Long getVisitedRecordsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        String url = "http://data-service:8081/api/report/getVisitedRecordsByDate?startDate="
                + startDate + "&endDate=" + endDate;

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Long.class)
                .block();
    }

    public Appointment getRecordById(Long id) {
        String url = "http://data-service:8081/api/appointment/getRecordById?id=" + id;

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(body -> new HttpResponseException("Ошибка сервиса: " + body))
                )
                .bodyToMono(Appointment.class)
                .block();
    }
}
