package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.PassengerController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.service.PassengerService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PassengerControllerImpl implements PassengerController {

    private final PassengerService passengerService;


    @Override
    public ResponseEntity<PassengerDTO> createPassenger(@Valid PassengerDTO passengerDTO) {
        return new ResponseEntity(passengerService.addPassanger(passengerDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> updatePassenger(@Valid PassengerDTO passengerDTO) {
        return new ResponseEntity(passengerService.updateAndSavePassenger(passengerDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(@Valid Long id) {
        return new ResponseEntity(passengerService.getPassengerById(id), HttpStatus.OK);
    }
}
