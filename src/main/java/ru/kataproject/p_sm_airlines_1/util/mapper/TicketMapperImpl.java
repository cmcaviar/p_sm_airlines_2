package ru.kataproject.p_sm_airlines_1.util.mapper;

import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketMapperImpl implements TicketMapper{
    @Override
    public Ticket mapDtoToTicket(final TicketDTO ticketDTO) {
        return new Ticket(ticketDTO.getId(), ticketDTO.getPassenger(),ticketDTO.getFlight(),ticketDTO.getSeat(),ticketDTO.getCategory(),ticketDTO.getReservationNumber());
    }

    @Override
    public TicketDTO mapTicketToDto(Ticket ticket) {
        return new TicketDTO(ticket.getId(), ticket.getPassenger(),ticket.getFlight(),ticket.getSeat(),ticket.getCategory(),ticket.getReservationNumber());
    }

    @Override
    public List<TicketDTO> mapTicketListToDto(List<Ticket> ticketList) {
        return ticketList.stream().map(this::mapTicketToDto).collect(Collectors.toList());
    }
}
