package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.controller.SeatController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import ru.kataproject.p_sm_airlines_1.service.SeatService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.SeatNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.handlers.SeatExceptionHandler;
import ru.kataproject.p_sm_airlines_1.util.mapper.SeatMapper;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@SeatExceptionHandler
@Log4j2
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;
    private final SeatMapper seatMapper;

    @Override
    public ResponseEntity<SeatDTO> getById(@RequestParam final Long id) {
        log.info("getById() with id = " + id);
        try {
            return new ResponseEntity<>(seatMapper.convertToDTO(seatService.getById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new SeatNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<Long> addSeat(@RequestBody final SeatDTO seatDTO) {
        log.info("addSeat() with seatDTO = " + seatDTO.toString());
        Seat seat = seatMapper.convertToEntity(seatDTO);
        seatService.addSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> updateSeat(final SeatDTO seatDTO) {
        log.info("updateSeat() with seatDTO = " + seatDTO.toString());
        Seat seat = seatMapper.convertToEntity(seatDTO);
        seatService.updateSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getSoldSeatsNumber() {
        log.info("getSoldSeatsNumber()");
        return new ResponseEntity<>(seatService.getSoldSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnSoldSeatsNumber() {
        log.info("getUnSoldSeatsNumber()");
        return new ResponseEntity<>(seatService.getUnSoldSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getRegisteredSeatsNumber() {
        log.info("getRegisteredSeatsNumber()");
        return new ResponseEntity<>(seatService.getRegisteredSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnRegisteredSeatsNumber() {
        log.info("getUnRegisteredSeatsNumber()");
        return new ResponseEntity<>(seatService.getUnRegisteredSeatsNumber(), HttpStatus.OK);
    }

}
