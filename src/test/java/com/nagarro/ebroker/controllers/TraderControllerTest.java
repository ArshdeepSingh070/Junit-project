package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TraderControllerTest {

    @InjectMocks
    private TraderController traderController;

    @Mock
    private TraderService traderService;

    @Mock
    private Trader trader;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Get trader by id")
    @Test
    public void shouldGetTraderById(){
        when(traderService.getTraderById(1)).thenReturn(trader);
        assertNotNull(traderController.getTraderById(1));
    }

    @DisplayName("Should not return any trader data if there is no equity for given id")
    @Test
    public void shouldNotGetTraderById(){
        when(traderService.getTraderById(1)).thenReturn(null);
        assertNull(traderController.getTraderById(1));
    }

    @DisplayName("create trader")
    @Test
    public void shouldCreateTrader(){
        when(traderService.createTrader(trader)).thenReturn(trader);
        assertNotNull(traderController.createTrader(trader));
    }

    @DisplayName("Should throw exception if trader data is empty")
    @Test
    public void shouldNotCreateTrader(){
        when(traderService.createTrader(null)).thenReturn(trader);
        Assertions.assertThrows(RuntimeException.class, ()-> traderController.createTrader(null));
    }

    @DisplayName("Add funds in trader account")
    @Test
    public void shouldAddFund(){
        when(traderService.addFunds(1,100)).thenReturn(trader);
        assertNotNull(traderController.addFund(1,100));
    }

    @DisplayName("Get all present equities")
    @Test
    public void shouldGetAllEquities(){
        Trader trader1 =  new Trader("arsh",20.0,null);
        Trader trader2 =  new Trader("other",20.0,null);
        List<Trader> traderList = new ArrayList<>();
        traderList.add(trader1);
        traderList.add(trader2);

        when(traderService.getAllTraders()).thenReturn(traderList);
        assertEquals(2, traderController.getAllEquities().size());
    }
}
