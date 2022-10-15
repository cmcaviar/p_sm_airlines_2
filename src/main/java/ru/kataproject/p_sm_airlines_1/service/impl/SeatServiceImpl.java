package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import ru.kataproject.p_sm_airlines_1.repository.SeatRepository;
import ru.kataproject.p_sm_airlines_1.service.SeatService;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;

    @Override
    public void addSeat(final Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public void updateSeat(final Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public Seat getById(final Long id){
        return seatRepository.getById(id);
    }

    @Override
    public int getSoldSeatsNumber() {
        return seatRepository.getByIsSold(true).size();
    }

    @Override
    public int getUnSoldSeatsNumber() {
        return seatRepository.getByIsSold(false).size();
    }

    @Override
    public int getRegisteredSeatsNumber() {
        return seatRepository.getByIsRegistered(true).size();
    }

    @Override
    public int getUnRegisteredSeatsNumber() {
        return seatRepository.getByIsRegistered(false).size();
    }
}
