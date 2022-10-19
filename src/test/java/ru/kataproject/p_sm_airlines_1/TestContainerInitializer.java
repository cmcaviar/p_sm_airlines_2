package ru.kataproject.p_sm_airlines_1;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DestinationDTO;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;

import java.util.TimeZone;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestContainerInitializer {

    @Autowired
    public TestRestTemplate restTemplate;

    @ClassRule
    private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14")
            .withDatabaseName("airline_db")
            .withUsername("postgres")
            .withPassword("root");

    @BeforeAll
    public static void init() {
        postgreSQLContainer.start();
        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", postgreSQLContainer.getUsername());
        System.setProperty("spring.datasource.password", postgreSQLContainer.getPassword());
        System.setProperty("spring.jpa.hibernate.ddl-auto", "create");
        System.setProperty("spring.liquibase.enabled", "false");
        System.setProperty("spring.jpa.show-sql", "false");
    }


}
