package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.TicketController;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;
import ru.kataproject.p_sm_airlines_1.service.TicketService;

@RequiredArgsConstructor
@RestController
public class TicketControllerImpl implements TicketController {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<String> create(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
        return new ResponseEntity<>(ticket.getId().toString(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update (@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
        return new ResponseEntity<>(ticket.getId().toString(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ticket> getById(@RequestParam Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ticket> getByReservationNumber(@RequestParam String reservationNumber) {
        Ticket ticket = ticketService.getTicketByPNR(reservationNumber);
        if (ticket == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
