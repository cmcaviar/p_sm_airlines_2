package ru.kataproject.p_sm_airlines_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Dto.FlightDTO;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.FlightStatus;

import java.time.LocalDateTime;
import java.util.TimeZone;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
@OrderWith(Alphanumeric.class)
public class FlightRestControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

     /*
      for correctly test need to change the type int to varchar(255) -> from create_table_destination.yaml
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build();
    }
      /*
      todo
      add tests for:
      получения по from & to & dates.
      получения свободных мест на рейсе (всех и с разбивкой по 2 классам (категориям) - бизнес и эконом)
      @link <a href="https://miro.com/app/board/uXjVPFFZSPA=/">miro (database link)</a>
     */

    @Test
    public void createFlight() throws Exception {
        mockMvc.perform(
                post("/v1/flight/create")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(getCreatedFlight()))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.from.city", equalTo("testCreate")));
    }

    @Test
    public void getFlightById() throws Exception {
        mockMvc.perform(
                get("/v1/flight/{id}", getCreatedFlight().getId()))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.from.city", equalTo("testCreate")));
    }

    @Test
    public void updateFlight() throws Exception {
        mockMvc.perform(
                put("/v1/flight/update")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(getUpdatedFlight()))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.from.city", equalTo("testUpdate")));
    }

    private FlightDTO getCreatedFlight() {
        String testCreate = "testCreate";
        return new FlightDTO(
            1L,
            new Destination(1L, testCreate, CountryCode.ABW, testCreate, testCreate, testCreate, TimeZone.getDefault()),
            new Destination(2L, testCreate, CountryCode.AIA, testCreate, testCreate, testCreate, TimeZone.getDefault()),
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(7),
            new Aircraft(1L, testCreate, testCreate, testCreate, 2022, 22, 1),
            FlightStatus.SCHEDULED
        );
    }

    private FlightDTO getUpdatedFlight() {
        String testUpdate = "testUpdate";
        return new FlightDTO(
            1L,
            new Destination(5L, testUpdate, CountryCode.AGO, testUpdate, testUpdate, testUpdate, TimeZone.getDefault()),
            new Destination(7L, testUpdate, CountryCode.ZWE, testUpdate, testUpdate, testUpdate, TimeZone.getDefault()),
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now(),
            new Aircraft(5L, testUpdate, testUpdate, testUpdate, 2023, 15, 3),
            FlightStatus.DELAYED
        );
    }
}