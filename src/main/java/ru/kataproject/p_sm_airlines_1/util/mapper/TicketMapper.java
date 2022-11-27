package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

import java.util.List;

public interface TicketMapper {

    Ticket mapDtoToTicket(final TicketDTO ticketDTO);

    TicketDTO mapTicketToDto(final Ticket ticket);

    List<TicketDTO> mapTicketListToDto(final List<Ticket> ticketList);
}
