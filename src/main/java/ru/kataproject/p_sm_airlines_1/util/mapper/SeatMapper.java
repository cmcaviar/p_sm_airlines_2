package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;
import ru.kataproject.p_sm_airlines_1.entity.Seat;

public interface SeatMapper {
    SeatDTO convertToDTO(Seat seat);

    Seat convertToEntity(SeatDTO seatDTO);
}
