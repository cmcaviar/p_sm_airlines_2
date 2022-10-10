package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.controller.SeatController;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import ru.kataproject.p_sm_airlines_1.service.SeatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeatControllerImpl implements SeatController {
    private final SeatService seatService;

    @Override
    public ResponseEntity<Seat> getById(@RequestParam Long id) {
        Seat seat = seatService.getById(id);

        if (seat != null) {
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> addSeat(@RequestBody Seat seat) {
        seatService.addSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateSeat(Seat seat) {
        seatService.updateSeat(seat);
        return new ResponseEntity<>(seat.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Seat>> getByFlight(@RequestParam Long flight_id) {
        List<Seat> result = seatService.getSeatsByFlightId(flight_id);

        if ((result == null) || (result.isEmpty())) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Seat>> getByFlightAndCategory(@RequestParam Long flight_id, @RequestParam Category name) {
        List<Seat> result = seatService.getSeatsByFlightIdAndCategoryId(flight_id, name);

        if ((result == null) || (result.isEmpty())) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Integer> getSoldSeatsNumber(@RequestParam Long flight_id) {
        return new ResponseEntity<>(seatService.getSoldSeatsNumber(flight_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnSoldSeatsNumber(@RequestParam Long flight_id) {
        return new ResponseEntity<>(seatService.getUnSoldSeatsNumber(flight_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getRegisteredSeatsNumber(Long flight_id) {
        return new ResponseEntity<>(seatService.getRegisteredPassengersNumber(flight_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getUnRegisteredSeatsNumber(Long flight_id) {
        return new ResponseEntity<>(seatService.getUnRegisteredPassengersNumber(flight_id), HttpStatus.OK);
    }

}
