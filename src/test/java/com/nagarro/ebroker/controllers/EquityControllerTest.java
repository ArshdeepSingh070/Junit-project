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

import java.util.ArrayList;
import java.util.List;

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
    public void shouldGetEquityById(){
        when(equityService.getEquityById(001)).thenReturn(equity);
        assertEquals(equity, equityController.getEquityById(001));
    }

    @Test
    public void shouldNotGetEquityById(){
        when(equityService.getEquityById(001)).thenReturn(null);
        assertEquals(null, equityController.getEquityById(001));
    }

   @Test
    public void shouldAddEquity(){
        Equity equitydata = new Equity("abc","this is abc stock",10.0);
        when(equityService.addEquity(equity)).thenReturn(equitydata);
        assertEquals(equitydata.getId(),equityController.addEquity(equity).getId());
    }

    @Test
    public void shouldNotAddEquity() throws Exception{
        Equity equitydata = new Equity("abc","this is abc stock",10.0);
        when(equityService.addEquity(null)).thenReturn(equitydata);
        assertEquals(null,equityController.addEquity(equity));
    }

    @Test
    public void shouldGetAllEquities(){
       Equity equity1 =  new Equity("abc","this is abc stock",10.0);
       Equity equity2 =  new Equity("mno","this is mno stock",10.0);
       Equity equity3 =  new Equity("xyz","this is xyz stock",10.0);
       List<Equity> equityList = new ArrayList<>();
       equityList.add(equity1);
       equityList.add(equity2);
       equityList.add(equity3);

       when(equityService.getAllEquities()).thenReturn(equityList);
       assertEquals(3, equityController.getAllEquities().size());
    }
}