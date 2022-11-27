package ru.kataproject.p_sm_airlines_1.entity.Enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlightStatus {

    SCHEDULED("По плану"),
    DELAYED("Задержан"),
    CANCELLED("Отменён");

    private final String status;
}
