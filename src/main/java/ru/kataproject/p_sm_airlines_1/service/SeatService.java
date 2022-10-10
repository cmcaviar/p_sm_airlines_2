package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Seat;

import java.util.List;

public interface SeatService {
    void addSeat(Seat seat);

    void updateSeat(Seat seat);

    Seat getById(Long id);

    List<Seat> getSeatsByFlightId(Long flightId);

    List<Seat> getSeatsByFlightIdAndCategoryId(Long flightId, Category name);

    int getSoldSeatsNumber(Long flightId);

    int getUnSoldSeatsNumber(Long flightId);

    int getRegisteredPassengersNumber(Long flightId);

    int getUnRegisteredPassengersNumber(Long flightId);
}
