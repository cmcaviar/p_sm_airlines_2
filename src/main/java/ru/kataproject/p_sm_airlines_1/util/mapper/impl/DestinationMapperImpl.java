package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.util.mapper.DestinationMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationMapperImpl implements DestinationMapper {

    @Override
    public Destination mapDtoToDestination(final DestinationDTO destinationDTO) {
        return new Destination(destinationDTO.getId(), destinationDTO.getCity(), destinationDTO.getCountryCode(),
                destinationDTO.getCountryName(), destinationDTO.getAirportName(), destinationDTO.getAirportCode(),
                destinationDTO.getTimeZone());
    }

    @Override
    public DestinationDTO mapDestinationToDto(final Destination destination) {
        return new DestinationDTO(destination.getId(), destination.getCity(), destination.getCountryCode(),
                destination.getCountryName(), destination.getAirportName(), destination.getAirportCode(),
                destination.getTimeZone());
    }

    @Override
    public List<DestinationDTO> mapDestinationListToDto(final List<Destination> destinationList) {
        return destinationList.stream().map(this::mapDestinationToDto).collect(Collectors.toList());
    }
}
