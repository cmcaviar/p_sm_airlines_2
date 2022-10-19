package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Dto.TicketDTO;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;
import ru.kataproject.p_sm_airlines_1.repository.TicketRepository;
import ru.kataproject.p_sm_airlines_1.service.TicketService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.TicketNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.mapper.TicketMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public String createReservationNumber(Long id) {
        String reservationNumber = "UX"+id*31;
        Ticket ticket = ticketRepository.getById(id);
        ticket.setReservationNumber(reservationNumber);
        return ticket.getReservationNumber();
    }

    @Override
    public TicketDTO createTicket(final TicketDTO ticketDTO) {
        Ticket savedTicket =
                ticketRepository.save(ticketMapper.mapDtoToTicket(ticketDTO));
        return ticketMapper.mapTicketToDto(savedTicket);
    }

    @Override
    public TicketDTO updateTicket(final TicketDTO ticketDTO) {
        Ticket updatedTicket =
                ticketRepository.save(ticketMapper.mapDtoToTicket(ticketDTO));
        return ticketMapper.mapTicketToDto(updatedTicket);    }

    @Override
    public List<TicketDTO> getTickets(final Long id, final String reservationNumber) {
        if(id!=null) {
            List<TicketDTO> list =
                    ticketMapper.mapTicketListToDto(ticketRepository.findAllById(Collections.singleton(id)));
            if (list.isEmpty()) {
                throw new TicketNotFoundException(id.toString());
            }
            return list;
        } else if (reservationNumber != null) {
            List<TicketDTO> list =
                    ticketMapper.mapTicketListToDto(ticketRepository.findTicketByReservationNumber(reservationNumber));
            if (list.isEmpty()) {
                throw new TicketNotFoundException(id.toString());
            }
            return list;
        } else {
            throw new TicketNotFoundException();
    }
    }
}
