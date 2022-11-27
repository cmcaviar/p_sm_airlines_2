package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;
import ru.kataproject.p_sm_airlines_1.entity.Flight;
import ru.kataproject.p_sm_airlines_1.util.mapper.FlightMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDTO mapToDTO(Flight flight) {
        return new FlightDTO(
            flight.getId(),
            flight.getFrom(),
            flight.getTo(),
            flight.getDepartureDateTime(),
            flight.getArrivalDateTime(),
            flight.getAircraft(),
            flight.getFlightStatus()
        );
    }

    @Override
    public List<FlightDTO> mapToDTOList(List<Flight> flightList) {
        return flightList.stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public Flight mapToEntity(FlightDTO flightDTO) {
        return new Flight(
            flightDTO.getId(),
            flightDTO.getFrom(),
            flightDTO.getTo(),
            flightDTO.getDepartureDateTime(),
            flightDTO.getArrivalDateTime(),
            flightDTO.getAircraft(),
            flightDTO.getFlightStatus()
        );
    }

    @Override
    public List<Flight> mapToEntityList(List<FlightDTO> flightDTOList) {
        return flightDTOList.stream()
            .map(this::mapToEntity)
            .collect(Collectors.toList());
    }
}
