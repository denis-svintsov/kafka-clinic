package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String phone;
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private String address;
    private String email;
    private List<Appointment> appointments = new ArrayList<>();
}
