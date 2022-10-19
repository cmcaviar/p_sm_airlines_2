package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;

import java.util.List;

@Tag(name = "Passenger API" , description = "Service of creating, updating and getting passenger by ID")
@RequestMapping(PassengerController.BASE_NAME)
public interface PassengerController {
    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/passenger";

    @PostMapping()
    @Operation(summary = "Create passenger", description = "Creates new passenger")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A new passenger has been successfully created",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PassengerDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Error creating a new passenger", content = @Content)
    })
    ResponseEntity<PassengerDTO> createPassenger(
            @Parameter(description = "Info about the new Destination") @RequestBody final PassengerDTO passengerDTO);


    @PutMapping()
    @Operation(summary = "Update passenger", description = "Edits passenger's fields")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Passenger successfully updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PassengerDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error updating passenger", content = @Content)
    })
    ResponseEntity<PassengerDTO> updatePassenger(
            @Parameter(description = "Info for updating the passenger") @RequestBody final PassengerDTO passengerDTO);

    @GetMapping()
    @Operation(summary = "Get passengers", description = "Get list of passengers")
    @Parameter(description = "Choosing a passengers by id", required = false, name = "id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DestinationDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Passengers are not found", content = @Content)
    })
    ResponseEntity<PassengerDTO> getPassengerById(
            @Parameter(description = "ID of the desired Passenger") @RequestParam(value = "id", required = false) final Long id);

}
