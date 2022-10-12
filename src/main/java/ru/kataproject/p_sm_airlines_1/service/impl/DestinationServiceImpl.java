package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.repository.DestinationRepository;
import ru.kataproject.p_sm_airlines_1.service.DestinationService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.DestinationNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.mapper.DestinationMapper;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;
    private final DestinationMapper destinationMapper;


    @Override
    public DestinationDTO createDestination(final DestinationDTO destinationDTO) {
        Destination savedDestination = destinationRepository.save(destinationMapper.mapDtoToDestination(destinationDTO));
        return destinationMapper.mapDestinationToDto(savedDestination);
    }

    @Override
    public DestinationDTO updateDestination(final DestinationDTO destinationDTO) {
        Destination updatedDestination = destinationRepository.save(destinationMapper.mapDtoToDestination(destinationDTO));
        return destinationMapper.mapDestinationToDto(updatedDestination);
    }

    @Override
    public List<DestinationDTO> getDestinations(final Long id, final String city, final String countryName) {
        if (id != null) {
            List<DestinationDTO> list = destinationMapper.mapDestinationListToDto(destinationRepository.findAllById(Collections.singleton(id)));
            if (list.isEmpty()) {throw new DestinationNotFoundException(id.toString());}
            return list;
        } else if (city != null) {
            List<DestinationDTO> list = destinationMapper.mapDestinationListToDto(destinationRepository.findByCity(city));
            if (list.isEmpty()) {throw new DestinationNotFoundException(city);}
            return list;
        } else if (countryName != null) {
            List<DestinationDTO> list = destinationMapper.mapDestinationListToDto(destinationRepository.findAllByCountryName(countryName));
            if (list.isEmpty()) {throw new DestinationNotFoundException(countryName);}
            return list;
        } else {
            throw new DestinationNotFoundException();
        }
    }
}
