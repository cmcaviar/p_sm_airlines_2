package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.FlightRestController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;
import ru.kataproject.p_sm_airlines_1.service.FlightService;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FlightRestControllerImpl implements FlightRestController {

    private final FlightService flightService;

    /*
      todo
      add:
      получения по from & to & dates.
      получения свободных мест на рейсе (всех и с разбивкой по 2 классам (категориям) - бизнес и эконом)
      @link <a href="https://miro.com/app/board/uXjVPFFZSPA=/">miro (database link)</a>
     */

    @Override
    public ResponseEntity<FlightDTO> createFlight(FlightDTO flightDTO) {
        return new ResponseEntity<>(flightService.createFlight(flightDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FlightDTO> updateFlight(FlightDTO flightDTO) {
        return new ResponseEntity<>(flightService.updateFlight(flightDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FlightDTO> getFlightById(Long id) {
        return new ResponseEntity<>(flightService.getFlightById(id), HttpStatus.OK);
    }
}
