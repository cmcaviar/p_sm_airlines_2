package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
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
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;
    private final SeatMapper seatMapper;

    @Override
    public ResponseEntity<SeatDTO> getById(@RequestParam final Long id){
        try {
            return new ResponseEntity<>(seatMapper.convertToDTO(seatService.getById(id)), HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            throw new SeatNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<?> addSeat(@RequestBody final SeatDTO seatDTO) {
        Seat seat = seatMapper.convertToEntity(seatDTO);
        seatService.addSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateSeat(final SeatDTO seatDTO) {
        Seat seat = seatMapper.convertToEntity(seatDTO);
        seatService.updateSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getSoldSeatsNumber() {
        return new ResponseEntity<>(seatService.getSoldSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnSoldSeatsNumber() {
        return new ResponseEntity<>(seatService.getUnSoldSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getRegisteredSeatsNumber() {
        return new ResponseEntity<>(seatService.getRegisteredSeatsNumber(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnRegisteredSeatsNumber() {
        return new ResponseEntity<>(seatService.getUnRegisteredSeatsNumber(), HttpStatus.OK);
    }

}
