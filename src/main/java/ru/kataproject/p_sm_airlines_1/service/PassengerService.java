package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;

public interface PassengerService {

    PassengerDTO addPassanger(final PassengerDTO passengerDTO);

    PassengerDTO updateAndSavePassenger(final PassengerDTO passengerDTO);

    PassengerDTO getPassengerById(final Long id);

}
