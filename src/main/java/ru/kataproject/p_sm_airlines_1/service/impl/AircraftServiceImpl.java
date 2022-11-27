package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.repository.AircraftRepository;
import ru.kataproject.p_sm_airlines_1.service.AircraftService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.AircraftNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    @Transactional
    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Transactional
    @Override
    public Aircraft getAircraftById(final Long id) {
        return aircraftRepository.findById(id).orElseThrow(() ->
                new AircraftNotFoundException("Aircraft not found with id " + id));
    }

    @Transactional
    @Override
    public void saveAircraft(final Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    @Transactional
    @Override
    public void updateAircraft(final Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    @Transactional
    @Override
    public void deleteAircraft(final Long id) {
        try {
            aircraftRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new AircraftNotFoundException("Aircraft not found with id " + id);
        }
    }
}
