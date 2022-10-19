package ru.kataproject.p_sm_airlines_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.kataproject.p_sm_airlines_1.entity.Dto.PassengerDTO;
import ru.kataproject.p_sm_airlines_1.entity.Passenger;
import ru.kataproject.p_sm_airlines_1.repository.PassengerRepository;
import ru.kataproject.p_sm_airlines_1.service.impl.PassengerServiceImpl;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PassengerControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerServiceImpl passengerService;

    PassengerDTO passenger_1 = new PassengerDTO(1l,"TestDocument","Test1@test","test_first_name1","test_last_name1","test_middle_name1"
            , LocalDate.of(1991,1,22));
    PassengerDTO passenger_2 = new PassengerDTO(1l,"TestDocument","Test1@test","test_first_name2","test_last_name2","test_middle_name1"
            , LocalDate.of(1991,1,22));


    @Test
    public void savePassengerTest() throws Exception {
        mockMvc.perform(post("/v1/passenger")
                        .content(objectMapper.writeValueAsString(passenger_1))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.document", Is.is("TestDocument")))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));

    }

    @Test
    public void getPassengerByIdTest() throws Exception {
        mockMvc.perform(post("/v1/passenger")
                .content(objectMapper.writeValueAsString(passenger_2))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(get("/v1/passenger?id={0}", passenger_2.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Is.is(2)))
                .andExpect(jsonPath("$[0].document", Is.is("TestDocument")))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void updatePassengerTest() throws Exception {
        Passenger updatePassenger_1 = new Passenger(1l,"TestDocument3","Test3@test","test_first_name3","test_last_name3","test_middle_name3"
                , LocalDate.of(1992,2,23));;
        mockMvc.perform(post("/v1/passenger")
                .content(objectMapper.writeValueAsString(passenger_1))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(put("/v1/passenger")
                        .content(objectMapper.writeValueAsString(updatePassenger_1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.document", Is.is(updatePassenger_1.getDocument())))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));
    }
}

