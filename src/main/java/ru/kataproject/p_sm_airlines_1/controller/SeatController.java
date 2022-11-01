package ru.kataproject.p_sm_airlines_1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kataproject.p_sm_airlines_1.entity.Dto.SeatDTO;

@Tag(name = "Seat Controller")
@RequestMapping(SeatController.BASE_NAME)
public interface SeatController {
    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/seat";

    @GetMapping("/get")
    @Operation(summary = "Get seat", description = "Get seat by seat id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Seat not found", content = @Content)})
    ResponseEntity<SeatDTO> getById(@Parameter(description = "Just seat id") final Long id);

    @PostMapping("/add")
    @Operation(summary = "Add seat", description = "Add new seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat was created successfully, seat id return",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seat wasn't created", content = @Content)})
    ResponseEntity<Long> addSeat(@Parameter(description = "Seat(DTO) that you need add") final SeatDTO seat);

    @PutMapping("/update")
    @Operation(summary = "Update seat", description = "Update seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat was updated successfully; seat id return",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seat wasn't updated", content = @Content)})
    ResponseEntity<Long> updateSeat(@Parameter(description = "Seat(DTO) that you need update") final SeatDTO seat);

    @GetMapping("/get-sold-number")
    @Operation(summary = "Get sold seats number", description = "Get sold seats number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats found", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seats not found", content = @Content)})
    ResponseEntity<Integer> getSoldSeatsNumber();

    @GetMapping("/get-unsold-number")
    @Operation(summary = "Get unsold seats number", description = "Get unsold seats number by flight id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats found", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seats not found", content = @Content)})
    ResponseEntity<Integer> getUnSoldSeatsNumber();

    @GetMapping("/get-registered-number")
    @Operation(summary = "Get registered seats number", description = "Get registered seats number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats found", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seats not found", content = @Content)})
    ResponseEntity<Integer> getRegisteredSeatsNumber();

    @GetMapping("/get-unregistered-number")
    @Operation(summary = "Get registered seats number", description = "Get registered seats number by flight id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats found", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Seats not found", content = @Content)})
    ResponseEntity<Integer> getUnRegisteredSeatsNumber();
}