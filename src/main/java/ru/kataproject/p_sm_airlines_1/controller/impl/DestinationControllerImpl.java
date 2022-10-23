package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DestinationController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.service.DestinationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class DestinationControllerImpl implements DestinationController {
    private final DestinationService destinationService;

    @Override
    public ResponseEntity<DestinationDTO> createDestination(final DestinationDTO destinationDTO) {
        log.info("createDestination()");
        DestinationDTO savedDestination = destinationService.createDestination(destinationDTO);
        return new ResponseEntity<>(savedDestination, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DestinationDTO> updateDestination(final DestinationDTO destinationDTO) {
        log.info("updateDestination() with id = " + destinationDTO.getId());
        destinationService.updateDestination(destinationDTO);
        return new ResponseEntity<>(destinationDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DestinationDTO>> getListOfDestinations(final Long id, final String city, final String countryName) {
        log.info("getListOfDestinations() with id = " + id + ", city = " + city + " and countryName = " + countryName);
        return new ResponseEntity<>(destinationService.getDestinations(id, city, countryName), HttpStatus.OK);
    }
}
