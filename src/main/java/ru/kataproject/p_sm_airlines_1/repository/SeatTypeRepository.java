package ru.kataproject.p_sm_airlines_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataproject.p_sm_airlines_1.entity.SeatType;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {}
