package ru.kataproject.p_sm_airlines_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataproject.p_sm_airlines_1.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findTicketByReservationNumber(String ReservationNumber);
}
