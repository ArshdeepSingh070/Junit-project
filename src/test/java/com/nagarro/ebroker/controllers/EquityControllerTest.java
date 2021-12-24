package com.nagarro.ebroker.controllers;


import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @DisplayName("Get equity by id")
    @Test
    public void shouldGetEquityById(){
        when(equityService.getEquityById(001)).thenReturn(equity);
        assertEquals(equity, equityController.getEquityById(001));
        assertNotNull(equityController.getEquityById(001));
    }

    @DisplayName("Should not return any equity data if there is no equity for given id")
    @Test
    public void shouldNotGetEquityById(){
        when(equityService.getEquityById(001)).thenReturn(null);
        assertEquals(null, equityController.getEquityById(001));
    }

    @DisplayName("Add equity")
   @Test
    public void shouldAddEquity(){
        Equity equitydata = new Equity("abc","this is abc stock",10.0);
        when(equityService.addEquity(equity)).thenReturn(equitydata);
        assertEquals(equitydata.getId(),equityController.addEquity(equity).getId());
    }

    @DisplayName("Should throw exception if equity data is empty")
    @Test
    public void shouldNotAddEquity(){
        when(equityService.addEquity(null)).thenReturn(equity);
        Assertions.assertThrows(RuntimeException.class, ()-> equityController.addEquity(null));
    }

    @DisplayName("Get all present equities")
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