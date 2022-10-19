package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

@Tag(name = "Ticket controller")
@RequestMapping(TicketController.BASE_NAME)
public interface TicketController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/ticket";

    @PostMapping("/create")
    @Operation(summary = "Create Ticket", description = "Create new ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error Creating new ticket", content = @Content)
    })
    ResponseEntity<String> create(@RequestBody Ticket ticket);

    @PutMapping("/update")
    @Operation(summary = "Update Ticket", description = "Update ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error updating ticket", content = @Content)
    })
    ResponseEntity<String> update(@RequestBody Ticket ticket);

    @GetMapping("/getById")
    @Operation(summary = "Get ticket", description = "Find ticket by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Ticket not found", content = @Content)
    })
    ResponseEntity<Ticket> getById(Long id);

    @GetMapping("/getByPNR")
    @Operation(summary = "Get ticket by Reservation number", description = "Find ticket by reservation number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Ticket not found", content = @Content)
    })
    ResponseEntity<Ticket> getByReservationNumber(String reservationNumber);
}