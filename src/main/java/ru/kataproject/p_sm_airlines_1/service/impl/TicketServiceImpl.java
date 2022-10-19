package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;
import ru.kataproject.p_sm_airlines_1.repository.TicketRepository;
import ru.kataproject.p_sm_airlines_1.service.TicketService;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public String createReservationNumber(Long id) {
        String reservationNumber = "UX"+id*31;
        Ticket ticket = ticketRepository.getById(id);
        ticket.setReservationNumber(reservationNumber);
        return ticket.getReservationNumber();
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket getTicketByPNR(String ReservationNumber) {
        return ticketRepository.findTicketByReservationNumber(ReservationNumber);
    }
}
