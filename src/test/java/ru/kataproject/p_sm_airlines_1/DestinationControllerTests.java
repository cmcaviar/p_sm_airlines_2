package ru.kataproject.p_sm_airlines_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.kataproject.p_sm_airlines_1.entity.Destination;
import ru.kataproject.p_sm_airlines_1.entity.Enumeration.CountryCode;
import ru.kataproject.p_sm_airlines_1.repository.DestinationRepository;
import ru.kataproject.p_sm_airlines_1.service.impl.DestinationServiceImpl;

import java.util.TimeZone;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DestinationControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    DestinationServiceImpl destinationService;

    Destination destination_1 = new Destination(1L, "TestCity1", CountryCode.RUS, "TestCountry1",
            "TestAirport1", "TestCode1", TimeZone.getTimeZone("1"));
    Destination destination_2 = new Destination(2L, "TestCity2", CountryCode.BLR, "TestCountry2",
            "TestAirport2", "TestCode2", TimeZone.getTimeZone("2"));
    Destination destination_3 = new Destination(3L, "TestCity3", CountryCode.RUS, "TestCountry1",
            "TestAirport3", "TestCode3", TimeZone.getTimeZone("3"));


    @Test
    public void saveDestinationTest() throws Exception {
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_1))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.city", Is.is("TestCity1")))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));

    }

    @Test
    public void getDestinationByIdTest() throws Exception {
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_2))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(get("/v1/destination?id={0}", destination_2.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Is.is(2)))
                .andExpect(jsonPath("$[0].city", Is.is("TestCity2")))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void getDestinationsByCountry() throws Exception {
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_1))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_2))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_3))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(get("/v1/destination?country_name={0}", "TestCountry1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$[0].countryName", Is.is("TestCountry1")))
                .andExpect(jsonPath("$[1].countryName", Is.is("TestCountry1")))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void updateDestinationTest() throws Exception {
        Destination updateDestination_1 = new Destination(1L, "Moscow", CountryCode.RUS, "Russia",
                "Domodedovo", "DME", TimeZone.getTimeZone("1"));
        mockMvc.perform(post("/v1/destination")
                .content(objectMapper.writeValueAsString(destination_1))
                .contentType(MediaType.APPLICATION_JSON)
        );
        mockMvc.perform(put("/v1/destination")
                .content(objectMapper.writeValueAsString(updateDestination_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.city", Is.is(updateDestination_1.getCity())))
                .andDo(MvcResult -> System.out.println(MvcResult.getResponse().getContentAsString()));
    }
}