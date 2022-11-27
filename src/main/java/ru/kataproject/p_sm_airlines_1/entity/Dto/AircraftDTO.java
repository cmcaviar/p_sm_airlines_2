package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftDTO {

    private Long id;
    private String tailNumber;
    private String brand;
    private String model;
    private Integer yearOfManufacture;
    private Integer flightRange;
    private Integer numberOfSeats;
    //plug (collection of categories of seats with numbers) TODO
//    String seatsByCategory;
}
