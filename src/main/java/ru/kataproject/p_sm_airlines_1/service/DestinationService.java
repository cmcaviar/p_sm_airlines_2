package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;

import java.util.List;

public interface DestinationService {

    DestinationDTO createDestination(final DestinationDTO destinationDTO);

    DestinationDTO updateDestination(final DestinationDTO destinationDTO);

    List<DestinationDTO> getDestinations(final Long id, final String city, final String countryName);
}
