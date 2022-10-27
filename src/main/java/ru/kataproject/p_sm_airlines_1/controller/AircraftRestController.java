package ru.kataproject.p_sm_airlines_1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDTO;

import java.util.List;

@Tag(name = "Aircraft controller")
@RequestMapping(AircraftRestController.BASE_NAME)
public interface AircraftRestController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/aircraft";

    @GetMapping
    @Operation(summary = "Get aircrafts",
            description = "Getting aircrafts from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aircrafts received successfully"
                    , content = @Content(mediaType = "application/json"
                    , schema = @Schema(implementation = AircraftDTO.class))),
            @ApiResponse(responseCode = "400", description = "Aircrafts receiving error", content = @Content)})
    List<AircraftDTO> getAllAircrafts();

    @GetMapping("/{id}")
    @Operation(summary = "Get an aircraft",
            description = "Getting an aircraft from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aircraft received successfully"
                    , content = @Content(mediaType = "application/json"
                    , schema = @Schema(implementation = AircraftDTO.class))),
            @ApiResponse(responseCode = "400", description = "Aircraft receiving error", content = @Content)})
    AircraftDTO getAircraftById(@PathVariable final Long id);

    @PostMapping
    @Operation(summary = "Create a new aircraft",
            description = "Create a new aircraft and saving to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aircraft successfully created"
                    , content = @Content(mediaType = "application/json"
                    , schema = @Schema(implementation = AircraftDTO.class))),
            @ApiResponse(responseCode = "400", description = "Aircraft creation error", content = @Content)})
    AircraftDTO saveAircraft(final AircraftDTO aircraftDTO);

    @PutMapping
    @Operation(summary = "Update an aircraft",
            description = "Update an aircraft and saving to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aircraft successfully updated"
                    , content = @Content(mediaType = "application/json"
                    , schema = @Schema(implementation = AircraftDTO.class))),
            @ApiResponse(responseCode = "400", description = "Aircraft update error", content = @Content)})
    AircraftDTO updateAircraft(final AircraftDTO aircraftDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an aircraft",
            description = "Delete an aircraft from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aircraft successfully removed"
                    , content = @Content(mediaType = "application/json"
                    , schema = @Schema(implementation = AircraftDTO.class))),
            @ApiResponse(responseCode = "400", description = "Aircraft deletion error", content = @Content)})
    void deleteAircraft(@PathVariable final Long id);
}