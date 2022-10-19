package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Ticket;

public interface TicketService {

    String createReservationNumber(Long id);
    void createTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    Ticket getTicketById(Long id);

    Ticket getTicketByPNR(String ReservationNumber);
}
