package ru.kataproject.p_sm_airlines_1.entity.Enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum SeatCategory {

    FIRST("First"),
    BUSINESS("Business"),
    ECONOMY("Economy");

    private final String seatCategory;

}
