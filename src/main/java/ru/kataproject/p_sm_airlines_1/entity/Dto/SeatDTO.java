package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDTO {
    private Long id;
    private String seatRow;
    private Integer seatNumber;
    private Long fare;
    private AircraftDTO aircraft;
    private Boolean isSold;
    private Boolean isRegistered;
}