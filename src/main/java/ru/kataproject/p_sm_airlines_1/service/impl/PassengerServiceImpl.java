package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;
import ru.kataproject.p_sm_airlines_1.repository.PassengerRepository;
import ru.kataproject.p_sm_airlines_1.service.PassengerService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.PassengerNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.mapper.PassengerMapper;


@Service
@Transactional
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    @Override
    public PassengerDTO addPassanger(PassengerDTO passengerDTO) {
        Passenger savePassenger = passengerRepository.save(passengerMapper.mapDtoToPassenger(passengerDTO));
        return passengerMapper.mapPassengerToDto(savePassenger);
    }

    @Override
    public PassengerDTO updateAndSavePassenger(PassengerDTO passengerDTO) {
        Passenger updatePassenger = passengerRepository.save(passengerMapper.mapDtoToPassenger(passengerDTO));
        return passengerMapper.mapPassengerToDto(updatePassenger);
    }

    @Override
    public PassengerDTO getPassengerById(Long id) {
        if (id != null) {
            return passengerMapper.mapPassengerToDto(passengerRepository.findById(id)
                    .orElseThrow(() -> new PassengerNotFoundException(id.toString())));
        } else {
            throw new PassengerNotFoundException(id.toString());
        }
    }
}