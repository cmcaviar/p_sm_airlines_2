package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;

@Tag(name = "Passenger API" , description = "Service of creating, updating and getting passenger by ID")
@RequestMapping(PassengerController.BASE_NAME)
public interface PassengerController {
    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/passenger";

    @Operation(summary = "Creating a new Passenger",
            description = "Creates a new user and saves to the database",
            tags = {"Passenger's operations"})
    @ApiResponse(responseCode = "200", description = "Passenger successfully created", content = @Content)
    @ApiResponse(responseCode = "400", description = "Error in creating a passenger", content = @Content)
    public ResponseEntity<PassengerDTO> addPassenger(PassengerDTO passengerDTO);

    @Operation(summary = "Changing an existing passenger",
            description = "Allows you to give access to change passenger data",
            tags = {"Passenger's operations"})
    @ApiResponse(responseCode = "200", description = "Passenger successfully update", content = @Content)
    @ApiResponse(responseCode = "400", description = "Error in updating a passenger", content = @Content)
    public ResponseEntity<PassengerDTO> updatePassenger(PassengerDTO passengerDTO);

    @Operation(summary = "Passenger search by id",
            description = "Allows you to find a passenger by id",
            tags = {"Passenger's operations"})
    @ApiResponse(responseCode = "200", description = "Passenger found", content = @Content)
    @ApiResponse(responseCode = "400", description = "Passenger not found", content = @Content)
    public ResponseEntity<PassengerDTO> getPassengerById(Long id);

}
