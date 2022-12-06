package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;

public interface FlightService {
    FlightDTO getFlightById(final Long id);
    FlightDTO createFlight(FlightDTO flightDTO);
    FlightDTO updateFlight(FlightDTO flightDTO);

    /*
      todo
      add methods without body:
      получения по from & to & dates.
      получения свободных мест на рейсе (всех и с разбивкой по 2 классам (категориям) - бизнес и эконом)
      @link <a href="https://miro.com/app/board/uXjVPFFZSPA=/">miro (database link)</a>
     */
}
