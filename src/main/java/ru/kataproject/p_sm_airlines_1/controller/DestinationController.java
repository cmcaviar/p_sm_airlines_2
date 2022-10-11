package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Destination;

import java.util.List;

@Tag(name = "Destination API", description = "Сервис получения направлений")
@RequestMapping(DestinationController.BASE_NAME)
public interface DestinationController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/destination";

    @PostMapping()
    @Operation(summary = "Create destination", description = "Creates new destination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A new destination has been succesfully created",
            content = @Content),
            @ApiResponse(responseCode = "400", description = "Error creating a new destination", content = @Content)
    })
    ResponseEntity<Destination> createDestination(@RequestBody Destination destination);

    @PutMapping()
    @Operation(summary = "Update destination", description = "Edits destination's fields")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination succesfully updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error updating destination", content = @Content)
    })
    ResponseEntity<Destination> updateDestination(@RequestBody Destination destination);

    @GetMapping()
    @Operation(summary = "Get destinations", description = "Get list of destinations")
    @Parameter(description = "Choosing a destination by id", required = false, name = "id")
    @Parameter(description = "Choosing a destination by city", required = false, name = "city")
    @Parameter(description = "Choosing destinations by country", required = false, name = "country_name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successful operation", content = @Content),
            @ApiResponse(responseCode = "400", description = "Destinations not found", content = @Content)
    })
    ResponseEntity<List<Destination>> getListOfDestinations(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "country_name", required = false) String countryName
    );
}
