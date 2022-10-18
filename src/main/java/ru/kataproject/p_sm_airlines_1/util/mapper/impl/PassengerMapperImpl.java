package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;
import ru.kataproject.p_sm_airlines_1.util.mapper.PassengerMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerMapperImpl implements PassengerMapper {

    @Override
    public Passenger mapDtoToPassenger(PassengerDTO passengerDTO) {
        return new Passenger(passengerDTO.getId(), passengerDTO.getCitizenship(), passengerDTO.getSeries(),
                passengerDTO.getNumber(), passengerDTO.getEmail(), passengerDTO.getFirst_name(), passengerDTO.getLast_name(),
                passengerDTO.getMiddle_name(), passengerDTO.getDate_of_birth());
    }

    @Override
    public PassengerDTO mapPassengerToDto(Passenger passenger) {
        return new PassengerDTO(passenger.getId(), passenger.getCitizenship(), passenger.getSeries(),
                passenger.getNumber(), passenger.getEmail(), passenger.getFirst_name(), passenger.getLast_name(),
                passenger.getMiddle_name(), passenger.getDate_of_birth());
    }

    @Override
    public List<PassengerDTO> mapPassengerListToDto(List<Passenger> passengerList) {
        return passengerList.stream().map(this::mapPassengerToDto).collect(Collectors.toList());
    }

}
