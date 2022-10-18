package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PassengerDTO {

    private Long id;

    private String citizenship; // Гражданство

    private Long series;   // Серия паспорта

    private Long number;   // Номер паспорта

    private String email;

    private String first_name;

    private String last_name;

    private String middle_name;

    private LocalDate date_of_birth;
}
