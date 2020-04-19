package guru.springframework.msccbeerserice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msccbeerserice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {
    @Autowired
    MockMvc mock;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void getBeerByIdTest() throws Exception {
        mock.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveBeerTest() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerObjJsonStr = objectMapper.writeValueAsString(beerDto);
        mock.perform(post("/api/v1/beer").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(beerObjJsonStr))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateBeerByIdTest() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerObjJsonStr = objectMapper.writeValueAsString(beerDto);
        mock.perform(put("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(beerObjJsonStr))
                .andExpect(status().isNoContent());
    }

}
