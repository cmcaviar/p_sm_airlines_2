package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.TicketController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;
import ru.kataproject.p_sm_airlines_1.service.TicketService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TicketControllerImpl implements TicketController {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<TicketDTO> createTicket (final TicketDTO ticketDTO) {
        TicketDTO savedTicket = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(savedTicket, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDTO> updateTicket (final TicketDTO ticketDTO) {
        ticketService.updateTicket(ticketDTO);
        return new ResponseEntity<>(ticketDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDTO>> getListOfTickets (final Long id, final String reservationNumber) {
        return new ResponseEntity<>(ticketService.getTickets(id,reservationNumber),HttpStatus.OK);
    }
}
