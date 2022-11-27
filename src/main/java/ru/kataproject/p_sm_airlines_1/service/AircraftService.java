package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;

import java.util.List;

public interface AircraftService {

    List<Aircraft> getAllAircrafts();

    Aircraft getAircraftById(final Long id);

    void saveAircraft(final Aircraft aircraft);

    void updateAircraft(final Aircraft aircraft);

    void deleteAircraft(final Long id);
}
