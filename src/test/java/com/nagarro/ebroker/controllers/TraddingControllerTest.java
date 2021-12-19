package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TraddingControllerTest {

    @InjectMocks
    private TraddingController traddingController;

    @Mock
    private EquityService equityService;

    @Mock
    private TraderService traderService;

    @Mock
    private TraddingService traddingService;

    /*@Mock
    private Equity equity;

    @Mock
    private Trader trader;*/

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        int i = 10;
        assertEquals(10,i);
    }

    @Test
    public void shouldSellEquity(){
        List<Equity> equityList = new ArrayList<>();
        Equity equity = new Equity("abc","abc stock",100);
        equityList.add(equity);
        Trader trader = new Trader(1,"arsh",1000.0,equityList);
        when(traderService.getTraderById(1)).thenReturn(trader);
        when(equityService.getEquityById(1)).thenReturn(equity);

        doNothing().when(traddingService).sellTraderEquity(trader,equity);

        assertNotNull(traddingController.sellEquity(1,1));
    }

    @Test
    public void shouldBuyEquity(){
        List<Equity> equityList = new ArrayList<>();
        Equity equity = new Equity("abc","abc stock",100);
        equityList.add(equity);
        Trader trader = new Trader(1,"arsh",1000.0,equityList);
        when(traderService.getTraderById(1)).thenReturn(trader);
        when(equityService.getEquityById(1)).thenReturn(equity);

        when(traddingService.buyEquity(trader,equity)).thenReturn("successfully bought");

        assertNotNull(traddingController.buyEquity(1,1));
        assertEquals("successfully bought", traddingController.buyEquity(1,1));
    }
}
