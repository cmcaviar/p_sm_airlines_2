package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;
import ru.kataproject.p_sm_airlines_1.entity.Flight;

import java.util.List;

public interface FlightMapper {
    FlightDTO mapToDTO(Flight flight);
    List<FlightDTO> mapToDTOList(List<Flight> flightList);
    Flight mapToEntity(FlightDTO flightDTO);
    List<Flight> mapToEntityList(List<FlightDTO> flightDTOList);
}
