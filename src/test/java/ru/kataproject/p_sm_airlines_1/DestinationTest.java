package ru.kataproject.p_sm_airlines_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;

import java.util.TimeZone;

public class DestinationTest extends TestContainerInitializer{

    DestinationDTO destination_1;
    DestinationDTO destination_2;
    DestinationDTO destination_3;

    @BeforeEach
    public void start() {
         destination_1 = new DestinationDTO(
                1L,
                "TestCity1",
                CountryCode.RUS,
                "TestCountry1",
                "TestAirport1",
                "TestCode1", TimeZone.getTimeZone("1"));

         destination_2 = new DestinationDTO(
                2L,
                "TestCity2",
                CountryCode.BLR,
                "TestCountry2",
                "TestAirport2",
                "TestCode2",
                TimeZone.getTimeZone("2"));

         destination_3 = new DestinationDTO(
                3L,
                "TestCity3",
                CountryCode.RUS,
                "TestCountry3",
                "TestAirport3",
                "TestCode3",
                TimeZone.getTimeZone("3"));
    }

    @Test
    public void saveDestinationTest() {
        ResponseEntity<DestinationDTO> response_1 = restTemplate.postForEntity("/v1/destination", destination_1, DestinationDTO.class);
        Assertions.assertEquals(response_1.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(destination_1, response_1.getBody());
    }

    @Test
    public void getDestination() {
        restTemplate.postForEntity("/v1/destination", destination_1, DestinationDTO.class);
        restTemplate.postForEntity("/v1/destination", destination_2, DestinationDTO.class);
        restTemplate.postForEntity("/v1/destination", destination_3, DestinationDTO.class);

        ResponseEntity<DestinationDTO[]> response_1 = restTemplate.getForEntity("/v1/destination?id=" + destination_1.getId(), DestinationDTO[].class);
        Assertions.assertEquals(1, response_1.getBody().length);
        Assertions.assertEquals(destination_1, response_1.getBody()[0]);

        ResponseEntity<DestinationDTO[]> response_2 = restTemplate.getForEntity("/v1/destination?city=" + destination_2.getCity(), DestinationDTO[].class);
        Assertions.assertEquals(1, response_2.getBody().length);
        Assertions.assertEquals(destination_2, response_2.getBody()[0]);

        ResponseEntity<DestinationDTO[]> response_3 = restTemplate.getForEntity("/v1/destination?country_name=" + destination_3.getCountryName(), DestinationDTO[].class);
        Assertions.assertEquals(1, response_3.getBody().length);
        Assertions.assertEquals(destination_3, response_3.getBody()[0]);
    }

    @Test
    public void updateDestination() {
        restTemplate.postForEntity("/v1/destination", destination_1, DestinationDTO.class);
        destination_1.setCity("UpdateCity");
        restTemplate.put("/v1/destination", destination_1);
        ResponseEntity<DestinationDTO[]> response_1 = restTemplate.getForEntity("/v1/destination?id=" + destination_1.getId(), DestinationDTO[].class);
        Assertions.assertEquals(destination_1, response_1.getBody()[0]);
    }

}
