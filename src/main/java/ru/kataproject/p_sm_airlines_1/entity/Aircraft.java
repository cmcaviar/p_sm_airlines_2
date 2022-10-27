package ru.kataproject.p_sm_airlines_1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tail_number")
    private String tailNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    @Column(name = "flight_range")
    private Integer flightRange;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

//    plug (collection of categories of seats with numbers) TODO
//    @Column(name = "seats_by_category")
//    String seatsByCategory;
}
