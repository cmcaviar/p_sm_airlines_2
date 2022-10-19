package ru.kataproject.p_sm_airlines_1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    /**@OneToMany
    @JoinColumn(name = "passenger_id")   //TODO Check after creating all of the entities and make sure all connections is working properly.
    private Passenger passenger;

    @OneToMany
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(name = "seat_category")
    private Category category;**/

    @Column(name = "reservation_number", nullable = false)
    private String ReservationNumber;

}
