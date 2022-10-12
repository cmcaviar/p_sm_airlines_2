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

import java.util.List;

@Tag(name = "Destination API", description = "Сервис получения направлений")
@RequestMapping(DestinationController.BASE_NAME)
public interface DestinationController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/destination";

    @PostMapping()
    @Operation(summary = "Create destination", description = "Creates new destination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A new destination has been successfully created",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DestinationDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error creating a new destination", content = @Content)
    })
    ResponseEntity<DestinationDTO> createDestination(
            @Parameter(description = "Info about the new Destination") @RequestBody final DestinationDTO destinationDTO);

    @PutMapping()
    @Operation(summary = "Update destination", description = "Edits destination's fields")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination successfully updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DestinationDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error updating destination", content = @Content)
    })
    ResponseEntity<DestinationDTO> updateDestination(
            @Parameter(description = "Info for updating the Destination") @RequestBody final DestinationDTO destinationDTO);

    @GetMapping()
    @Operation(summary = "Get destinations", description = "Get list of destinations")
    @Parameter(description = "Choosing a destination by id", required = false, name = "id")
    @Parameter(description = "Choosing a destination by city", required = false, name = "city")
    @Parameter(description = "Choosing destinations by country", required = false, name = "country_name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DestinationDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Destinations are not found", content = @Content)
    })
    ResponseEntity<List<DestinationDTO>> getListOfDestinations(
            @Parameter(description = "ID of the desired Destination") @RequestParam(value = "id", required = false) final Long id,
            @Parameter(description = "City of the desired Destination") @RequestParam(value = "city", required = false) final String city,
            @Parameter(description = "Country of the desired Destination") @RequestParam(value = "country_name", required = false) final String countryName
    );
}
