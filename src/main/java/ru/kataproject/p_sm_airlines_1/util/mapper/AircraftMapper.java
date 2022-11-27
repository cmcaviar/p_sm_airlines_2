package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDTO;

public interface AircraftMapper {

    Aircraft convertToEntity(final AircraftDTO aircraftDTO);

    AircraftDTO convertToDTO(final Aircraft aircraft);

}
