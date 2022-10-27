package ru.kataproject.p_sm_airlines_1.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AircraftApiFailure {

    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;
}
