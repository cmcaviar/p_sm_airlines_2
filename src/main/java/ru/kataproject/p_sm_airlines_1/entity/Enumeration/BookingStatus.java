package ru.kataproject.p_sm_airlines_1.entity.Enumeration;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingStatus {
    RESERVED("Зарезервировано"),
    PAID("Оплачено"),
    CANCELED("Отменено");

    private final String status;
}
