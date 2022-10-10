package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Seat;
import ru.kataproject.p_sm_airlines_1.repository.SeatRepository;
import ru.kataproject.p_sm_airlines_1.service.SeatService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    @Override
    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public void updateSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public Seat getById(Long id) {
        return seatRepository.getById(id);
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> convert in one list
     */
    @Override
    public List<Seat> getSeatsByFlightId(Long flightId) {
        return flightRepository.getById(flightId).getAircraft().getSeatsByCategory().values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> get by category
     */
    @Override
    public List<Seat> getSeatsByFlightIdAndCategoryId(Long flightId, Category name) {
        return flightRepository.getById(flightId).getAircraft().getSeatsByCategory().get(name);
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> convert in one list --> count
     */
    @Override
    public int getSoldSeatsNumber(Long flightId) {
        return (int) flightRepository.getById(flightId).getAircraft().getSeatsByCategory().values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Seat::getIsSold).count();
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> convert in one list --> count
     */
    @Override
    public int getUnSoldSeatsNumber(Long flightId) {
        return (int) flightRepository.getById(flightId).getAircraft().getSeatsByCategory().values()
                .stream()
                .flatMap(Collection::stream)
                .filter(seat -> !seat.getIsSold()).count();
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> convert in one list --> count
     */
    @Override
    public int getRegisteredPassengersNumber(Long flightId) {
        return (int) flightRepository.getById(flightId).getAircraft().getSeatsByCategory().values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Seat::getIsRegistered).count();
    }

    /**
     * get flight by id --> get aircraft --> get map <category, list<Seat>> --> convert in one list --> count
     */
    @Override
    public int getUnRegisteredPassengersNumber(Long flightId) {
        return (int) flightRepository.getById(flightId).getAircraft().getSeatsByCategory().values()
                .stream()
                .flatMap(Collection::stream)
                .filter(seat -> !seat.getIsRegistered()).count();
    }

}
