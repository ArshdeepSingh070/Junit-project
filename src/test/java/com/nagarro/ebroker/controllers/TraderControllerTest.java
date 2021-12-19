package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

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

    @Test
    public void test(){
        int i = 10;
        assertNotNull(i);
    }

    @Test
    public void shouldGetTraderById(){
        when(traderService.getTraderById(1)).thenReturn(trader);
        assertNotNull(traderController.getTraderById(1));
    }

    @Test
    public void shouldNotGetTraderById(){
        when(traderService.getTraderById(1)).thenReturn(null);
        assertNull(traderController.getTraderById(1));
    }

    @Test
    public void shouldCreateTrader(){
        when(traderService.createTrader(trader)).thenReturn(trader);
        assertNotNull(traderController.createTrader(trader));
    }

    @Test
    public void shouldAddFund(){
        when(traderService.addFunds(1,100)).thenReturn(trader);
        assertNotNull(traderController.addFund(1,100));
    }
}
