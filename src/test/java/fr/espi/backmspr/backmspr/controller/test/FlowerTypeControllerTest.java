package fr.espi.backmspr.backmspr.controller.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.espi.backmspr.backmspr.controller.FlowerController;
import fr.espi.backmspr.backmspr.controller.FlowerTypeController;
import fr.espi.backmspr.backmspr.entity.FlowerTypeEntity;
import fr.espi.backmspr.backmspr.entity.dto.FlowerDTO;
import fr.espi.backmspr.backmspr.service.FlowerService;
import fr.espi.backmspr.backmspr.service.FlowerTypeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(FlowerTypeController.class)
public class FlowerTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlowerTypeService service;

    @Test
    public void testGetAll() throws Exception {


        List<FlowerTypeEntity> list = Arrays.asList(
            new FlowerTypeEntity("Rose","Test"),
            new FlowerTypeEntity("Rose","Description1")
        );

        when(service.getAll()).thenReturn(list);

        mockMvc.perform(get("/flowerType"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$" , Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Rose")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test")))
                .andExpect(jsonPath("$[1].name", Matchers.is("Rose")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Description1")));
    }

    @Test
    public void FlowerTestMake() throws Exception {
        mockMvc.perform(post("/flowerType/make")
                        .content(asJsonString(new FlowerTypeEntity("une rose","description")))
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
