package ru.kataproject.p_sm_airlines_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataproject.p_sm_airlines_1.entity.Destination;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findByCity (String city);

    List<Destination> findAllByCountryName (String countryName);
}
