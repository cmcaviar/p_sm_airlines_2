package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;

import java.util.TimeZone;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class DestinationDTO {

    private Long id;

    private String city;

    private CountryCode countryCode;

    private String countryName;

    private String airportName;

    private String airportCode;

    private TimeZone timeZone;
}
