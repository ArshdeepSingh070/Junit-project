package com.nagarro.ebroker.controllers;


import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
public class TraderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test(){
        int i = 10;
        Assertions.assertNotNull(i);
    }

    @DisplayName("Broad Integration test for trader controller")
    @Test
    public void shouldCreateTrader() throws Exception {

        //create
        mockMvc.perform(MockMvcRequestBuilders.post("/trader/createTrader")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content("{" +
                         " \"id\" : \"1\", \n" +
                         " \"name\" : \"arsh\", \n" +
                         " \"availableFunds\" : \"20.0\", \n" +
                         "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", Matchers.is(1)));

        // get all part
        mockMvc.perform(MockMvcRequestBuilders.get("/trader/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));

    }
}
