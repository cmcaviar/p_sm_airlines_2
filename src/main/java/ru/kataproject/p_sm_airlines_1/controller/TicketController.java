package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

import java.util.List;

@Tag(name = "Ticket API", description = "Service of creating, updating and getting Tickets by ID/Reservation number")
@RequestMapping(TicketController.BASE_NAME)
public interface TicketController {

    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/ticket";

    @PostMapping()
    @Operation(summary = "Create Ticket", description = "Create new ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error Creating new ticket", content = @Content)
    })
    ResponseEntity<TicketDTO> createTicket(
            @Parameter(description = "Info about the new Ticket") @RequestBody final TicketDTO ticketDTO);

    @PutMapping()
    @Operation(summary = "Update Ticket", description = "Edits Ticket details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error updating ticket", content = @Content)
    })
    ResponseEntity<TicketDTO> updateTicket(
            @Parameter(description = "Info for updating the Ticket") @RequestBody final TicketDTO ticketDTO);

    @GetMapping()
    @Operation(summary = "Get ticket", description = "Get list of tickets")
    @Parameter(description = "Get a ticket by id", required = false, name = "id")
    @Parameter(description = "Get a ticket by Reservation number", required = false, name = "reservation_number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TicketDTO.class))
            }), @ApiResponse(responseCode = "400", description = "Ticket not found", content = @Content)
    })
    ResponseEntity<List<TicketDTO> getListOfTickets(
            @Parameter(description = "ID of desired Ticket") @RequestParam(value = "id", required = false) final Long id,
            @Parameter(description = "Reservation number of desired Ticket") @RequestParam(value = "reservation_number", required = false) final String reservationNumber);

    ResponseEntity<TicketDTO> createTicket(@RequestBody Ticket ticket);

    ResponseEntity<String> updateTicket(@RequestBody Ticket ticket);

    ResponseEntity<Ticket> getListOfTickets(@RequestParam Long id);
}