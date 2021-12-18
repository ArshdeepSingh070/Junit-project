package com.nagarro.ebroker.controllers;


import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class EquityControllerTest {

    @InjectMocks
    private EquityController equityController;

    @Mock
    EquityService equityService;

    @Mock
    private Equity equity;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFirst(){
        int i = 10;
        assertEquals(10,i);
    }

    @Test
    public void getEquityByIdTest(){
        when(equityService.getEquityById("001")).thenReturn(equity);
        assertEquals(equity, equityController.getEquityById("001"));
    }

}