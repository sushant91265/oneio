package com.test.oneio.controller;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.test.oneio.model.FizzBuzzGameResponseModel;
import com.test.oneio.service.Impl.FizzBuzzService;

/*
 * FizzBuzzControllerTest is the test class for FizzBuzzController, testing the 
 * api calls
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(value = FizzBuzzController.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService fizzBuzzService;
    
    @Test
    public void testFizzBuzzController() throws Exception {
        FizzBuzzGameResponseModel response = new FizzBuzzGameResponseModel(Collections.singletonList("1"));
        Mockito.when(fizzBuzzService.playGame(Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/games/v1/fizzbuzz")
                        .queryParam("start", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(fizzBuzzService, Mockito.times(1)).playGame(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void testFizzBuzzControllerWith2Params() throws Exception {
        FizzBuzzGameResponseModel response = new FizzBuzzGameResponseModel(Collections.singletonList("1"));
        Mockito.when(fizzBuzzService.playGame(Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/games/v1/fizzbuzz?start=3&size=2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(fizzBuzzService, Mockito.times(1)).playGame(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void testFizzBuzzControllerDoNotThrowException() throws Exception {
        FizzBuzzGameResponseModel response = new FizzBuzzGameResponseModel(Collections.singletonList("1"));
        Mockito.when(fizzBuzzService.playGame(Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/games/v1/fizzbuzz?start=0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(fizzBuzzService, Mockito.times(1)).playGame(Mockito.anyInt(), Mockito.anyInt());
    }
}
