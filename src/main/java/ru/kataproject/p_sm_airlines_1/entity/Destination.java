package ru.kataproject.p_sm_airlines_1.entity;

import lombok.*;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;

import javax.persistence.*;
import java.util.TimeZone;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "country_code")
    private CountryCode countryCode;

    @NonNull
    @Column(name = "country_name")
    String countryName;

    @NonNull
    @Column(name = "airport_name")
    String airportName;

    @NonNull
    @Column(name = "airport_code")
    String airportCode;

    @Column(name = "timezone")
    TimeZone timeZone;
}
