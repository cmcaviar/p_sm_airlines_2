package ru.kataproject.p_sm_airlines_1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;

@Tag(name = "Flight API")
@RequestMapping(FlightRestController.BASE_NAME)
public interface FlightRestController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/flight";

    /*
      todo
      add:
      получения по from & to & dates.
      получения свободных мест на рейсе (всех и с разбивкой по 2 классам (категориям) - бизнес и эконом)
      @link <a href="https://miro.com/app/board/uXjVPFFZSPA=/">miro (database link)</a>
     */

    @GetMapping("/{id}")
    @Operation(summary = "Gets flight", description = "Get flight by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success! Flight found", content = @Content(
            mediaType = "application/json", schema = @Schema(implementation = FlightDTO.class))),
        @ApiResponse(responseCode = "404", description = "Failure! Flight not found", content = @Content)
    })
    ResponseEntity<FlightDTO> getFlightById(@PathVariable("id") Long id);

    @PostMapping("/create")
    @Operation(summary = "Create flight", description = "Create a new flight")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flight successfully created", content = @Content(
            mediaType = "application/json", schema = @Schema(implementation = FlightDTO.class))),
        @ApiResponse(responseCode = "400", description = "Flight creation error", content = @Content)
    })
    ResponseEntity<FlightDTO> createFlight(@Parameter(description = "Flight's info") @RequestBody FlightDTO flightDTO);

    @PutMapping("/update")
    @Operation(summary = "Update flight", description = "update the existing flight")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flight successfully updated", content = @Content(
            mediaType = "application/json", schema = @Schema(implementation = FlightDTO.class))),
        @ApiResponse(responseCode = "400", description = "Flight updating error", content = @Content)
    })
    ResponseEntity<FlightDTO> updateFlight(@Parameter(description = "Updated flight's info") @RequestBody FlightDTO flightDTO);
}
