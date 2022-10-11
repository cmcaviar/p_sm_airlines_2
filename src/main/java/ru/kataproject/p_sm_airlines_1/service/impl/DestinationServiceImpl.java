package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.repository.DestinationRepository;
import ru.kataproject.p_sm_airlines_1.service.DestinationService;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;


    @Override
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination updateDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> getDestinations(Long id, String city, String countryName) {
        if (id != null) {
            return destinationRepository.findAllById(Collections.singleton(id));
        } else if (city != null) {
            return destinationRepository.findByCity(city);
        } else if (countryName != null) {
            return destinationRepository.findAllByCountryName(countryName);
        } else {
            return Collections.emptyList();
        }
    }
}
