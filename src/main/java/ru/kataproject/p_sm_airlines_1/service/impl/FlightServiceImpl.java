package ru.kataproject.p_sm_airlines_1.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;
import ru.kataproject.p_sm_airlines_1.repository.FlightRepository;
import ru.kataproject.p_sm_airlines_1.service.FlightService;
import ru.kataproject.p_sm_airlines_1.util.mapper.FlightMapper;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    /*
      todo
      add override methods:
      получения по from & to & dates.
      получения свободных мест на рейсе (всех и с разбивкой по 2 классам (категориям) - бизнес и эконом)
      @link <a href="https://miro.com/app/board/uXjVPFFZSPA=/">miro (database link)</a>
     */

    @Override
    public FlightDTO getFlightById(Long id) {
        boolean isExists = flightRepository.existsById(id);
        if (isExists) {
            return flightMapper.mapToDTO(flightRepository.getById(id));
        } else {
            throw new RuntimeException("Object not found");
        }
    }

    @Override
    public FlightDTO createFlight(FlightDTO flightDTO) {
        boolean isExists = flightRepository.existsById(flightDTO.getId());
        if (isExists) {
            throw new RuntimeException("Object already exists");
        } else {
            return flightMapper.mapToDTO(flightRepository.save(flightMapper.mapToEntity(flightDTO)));
        }
    }

    @Override
    public FlightDTO updateFlight(FlightDTO flightDTO) {
        boolean isExists = flightRepository.existsById(flightDTO.getId());
        if (isExists) {
            return flightMapper.mapToDTO(flightRepository.save(flightMapper.mapToEntity(flightDTO)));
        } else {
            throw new RuntimeException("Object not found");
        }
    }

}
