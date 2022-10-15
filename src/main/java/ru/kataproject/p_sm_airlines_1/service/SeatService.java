package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Seat;

public interface SeatService {
    void addSeat(Seat seat);

    void updateSeat(Seat seat);

    Seat getById(Long id);

    int getSoldSeatsNumber();

    int getUnSoldSeatsNumber();

    int getRegisteredSeatsNumber();

    int getUnRegisteredSeatsNumber();

}
