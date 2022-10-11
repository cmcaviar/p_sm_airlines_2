package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DestinationController;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.service.DestinationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DestinationControllerImpl implements DestinationController {


    private final DestinationService destinationService;

    @Override
    public ResponseEntity<Destination> createDestination(Destination destination) {
        Destination savedDestination = destinationService.createDestination(destination);
        return new ResponseEntity<>(savedDestination, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Destination> updateDestination(Destination destination) {
        destinationService.updateDestination(destination);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Destination>> getListOfDestinations(Long id, String city, String countryName) {
        return new ResponseEntity<>(destinationService.getDestinations(id, city, countryName), HttpStatus.OK);
    }
}
