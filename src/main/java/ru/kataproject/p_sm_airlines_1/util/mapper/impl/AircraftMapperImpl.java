package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDTO;
import ru.kataproject.p_sm_airlines_1.util.mapper.AircraftMapper;

@Service
public class AircraftMapperImpl implements AircraftMapper {

    @Override
    public Aircraft convertToEntity(final AircraftDTO aircraftDTO) {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(aircraftDTO.getId());
        aircraft.setTailNumber(aircraftDTO.getTailNumber());
        aircraft.setBrand(aircraftDTO.getBrand());
        aircraft.setModel(aircraftDTO.getModel());
        aircraft.setYearOfManufacture(aircraftDTO.getYearOfManufacture());
        aircraft.setFlightRange(aircraftDTO.getFlightRange());

        return aircraft;
    }

    @Override
    public AircraftDTO convertToDTO(Aircraft aircraft) {
        AircraftDTO aircraftDTO = new AircraftDTO();
        aircraftDTO.setId(aircraft.getId());
        aircraftDTO.setTailNumber(aircraft.getTailNumber());
        aircraftDTO.setBrand(aircraft.getBrand());
        aircraftDTO.setModel(aircraft.getModel());
        aircraftDTO.setYearOfManufacture(aircraft.getYearOfManufacture());
        aircraftDTO.setFlightRange(aircraft.getFlightRange());

        return aircraftDTO;
    }
}
