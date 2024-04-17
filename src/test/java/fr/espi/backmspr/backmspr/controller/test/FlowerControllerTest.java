package fr.espi.backmspr.backmspr.controller.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.espi.backmspr.backmspr.controller.FlowerController;
import fr.espi.backmspr.backmspr.entity.FlowerEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerDTO;
import fr.espi.backmspr.backmspr.entity.dto.UserDTO;
import fr.espi.backmspr.backmspr.service.FlowerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.List;


@WebMvcTest(FlowerController.class)
public class FlowerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlowerService service;

    @Test
    public void getAllFlower() throws Exception{

        List<FlowerEntity> list = Arrays.asList(
                new FlowerEntity(1 , "Rose" , "une belle Rose", 111.0,111.0, "Lille", "titre"),
                new FlowerEntity(2 , "Tulipe" , "une belle Tulipe", 120.0 , 120.0, "Roubaix", "Titre2")
        );

        when(service.getAll()).thenReturn(list);

        mockMvc.perform(get("/flowers"))
                .andDo(print()).andExpect(status().isOk())

                .andExpect(jsonPath("$" , Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$[0].flower", Matchers.is("Rose")))
                .andExpect(jsonPath("$[0].description", Matchers.is("une belle Rose")))
                .andExpect(jsonPath("$[0].longitude", Matchers.is(111.0)))
                .andExpect(jsonPath("$[0].latitude", Matchers.is(111.0)))
                .andExpect(jsonPath("$[0].locationName", Matchers.is("Lille")))
                .andExpect(jsonPath("$[0].titre", Matchers.is("titre")))

                .andExpect(jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(jsonPath("$[1].flower", Matchers.is("Tulipe")))
                .andExpect(jsonPath("$[1].description", Matchers.is("une belle Tulipe")))
                .andExpect(jsonPath("$[1].longitude", Matchers.is(120.0)))
                .andExpect(jsonPath("$[1].latitude", Matchers.is(120.0)))
                .andExpect(jsonPath("$[1].locationName", Matchers.is("Roubaix")))
                .andExpect(jsonPath("$[1].titre", Matchers.is("Titre2")));
    }

    @Test
    public void FlowerTestMake() throws Exception {
        mockMvc.perform(post("/flowers/make")
                        .content(asJsonString(new FlowerDTO(1L,"une rose","rose", 111.0 ,111.0, "Lille", "titre")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
