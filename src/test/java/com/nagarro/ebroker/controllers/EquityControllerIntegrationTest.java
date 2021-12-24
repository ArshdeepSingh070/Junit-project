package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@WebMvcTest(EquityController.class)
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
public class EquityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquityService equityService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Narrow Integration test for get all equities from /equity/getAll api call")
    @Test
    public void testGetAllEquities() throws Exception {
        Equity equity1 =  new Equity("abc","this is abc stock",10.0);
        Equity equity2 =  new Equity("mno","this is mno stock",10.0);
        List<Equity> equityList = new ArrayList<>();
        equityList.add(equity1);
        equityList.add(equity2);

        when(equityService.getAllEquities()).thenReturn(equityList);

        mockMvc.perform(MockMvcRequestBuilders.get("/equity/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }
}
