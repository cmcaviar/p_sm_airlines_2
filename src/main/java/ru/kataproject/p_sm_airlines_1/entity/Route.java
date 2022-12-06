package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.TimeZone;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "from")
    private Destination from;

    @NonNull
    @Column(name = "to")
    private Destination to;

    @NonNull
    @Column(name = "departure_date")
    private LocalDate departure_date;

    @NonNull
    @Column(name = "arrival_date")
    private LocalDate arrival_date;

    @NonNull
    @Column(name = "number_of_seats")
    private Integer number_of_seats;
}


