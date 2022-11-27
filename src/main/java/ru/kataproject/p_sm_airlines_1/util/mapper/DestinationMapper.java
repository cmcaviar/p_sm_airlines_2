package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;

import java.util.List;

public interface DestinationMapper {

    Destination mapDtoToDestination (final DestinationDTO destinationDTO);

    DestinationDTO mapDestinationToDto (final Destination destination);

    List<DestinationDTO> mapDestinationListToDto (final List<Destination> destinationList);

}
