package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.PassengerController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.service.PassengerService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PassengerControllerImpl implements PassengerController {

    private final PassengerService passengerService;


    @Override
    public ResponseEntity<PassengerDTO> createPassenger(@Valid PassengerDTO passengerDTO) {
        log.info("createPassenger()");
        return new ResponseEntity(passengerService.addPassanger(passengerDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> updatePassenger(@Valid PassengerDTO passengerDTO) {
        log.info("updatePassenger() with id = " + passengerDTO.getId());
        return new ResponseEntity(passengerService.updateAndSavePassenger(passengerDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(@Valid Long id) {
        log.info("getPassengerById() with id = " + id);
        return new ResponseEntity(passengerService.getPassengerById(id), HttpStatus.OK);
    }
}
