package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Destination;
import java.util.List;

public interface DestinationService {

    Destination createDestination(Destination destination);

    Destination updateDestination(Destination destination);

    List<Destination> getDestinations(Long id, String city, String countryName);
}
