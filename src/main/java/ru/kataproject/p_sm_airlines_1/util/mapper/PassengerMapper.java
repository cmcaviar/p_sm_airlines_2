package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;


import java.util.List;

public interface PassengerMapper {

    Passenger mapDtoToPassenger (final PassengerDTO passengerDTO);

    PassengerDTO mapPassengerToDto (final Passenger passenger);

    List<PassengerDTO> mapPassengerListToDto (final List<Passenger> passengerList);

}
