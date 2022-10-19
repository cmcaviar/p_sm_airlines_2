package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketDTO {

    private Long id;

     //TODO Check after creating all of the entities and make sure all connections is working properly.
     private Passenger passenger;

     private Flight flight;

     private Seat seat;

     private Category category;

     private String ReservationNumber;
}
