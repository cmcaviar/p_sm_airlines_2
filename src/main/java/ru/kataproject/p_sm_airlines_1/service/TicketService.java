package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

import java.util.List;

public interface TicketService {

    String createReservationNumber(final Long id);
    TicketDTO createTicket(final TicketDTO ticketDTO);
    TicketDTO updateTicket(final TicketDTO ticketDTO);

    List<TicketDTO> getTickets(final Long id, final String reservationNumber);
}
