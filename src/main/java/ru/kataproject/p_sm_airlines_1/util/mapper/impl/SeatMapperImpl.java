package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import ru.kataproject.p_sm_airlines_1.util.mapper.SeatMapper;

@Component
@RequiredArgsConstructor
public class SeatMapperImpl implements SeatMapper {

    @Override
    public SeatDTO convertToDTO(Seat seat) {
        SeatDTO dto = new SeatDTO();
        dto.setId(seat.getId());
        dto.setSeatRow(seat.getSeatRow());
        dto.setSeatNumber(seat.getSeatNumber());
        dto.setFare(seat.getFare());
//        dto.setAircraft(seat.getAircraft()); //TODO uncomment after creating aircraft
        dto.setIsSold(seat.getIsSold());
        dto.setIsRegistered(seat.getIsRegistered());

        return dto;
    }

    @Override
    public Seat convertToEntity(SeatDTO dto) {
        Seat seat = new Seat();
        seat.setId(dto.getId());
        seat.setSeatRow(dto.getSeatRow());
        seat.setSeatNumber(dto.getSeatNumber());
        seat.setFare(dto.getFare());
//        seat.setAircraft(dto.getAircraft()); //TODO uncomment after creating aircraft
        seat.setIsSold(dto.getIsSold());
        seat.setIsRegistered(dto.getIsRegistered());

        return seat;
    }
}
