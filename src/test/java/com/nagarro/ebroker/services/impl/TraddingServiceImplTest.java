package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraderService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TraddingServiceImplTest {

    @InjectMocks
    private TraddingServiceImpl traddingService;

    @Mock
    TraderService traderService;

    @Mock
    EquityService equityService;

    @Mock
    Equity equity;

    @Mock
    Trader trader;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldSellTraderEquity(){
        when(traderService.sellEquity(trader,equity)).thenReturn("sold successfully");
        traddingService.sellTraderEquity(trader,equity);
        verify(traderService,times(1)).sellEquity(trader,equity);
    }

    @Test
    public void shouldBuyEquity(){
        Trader trader = new Trader("arsh",100,null);
        Equity equity = new Equity("abc", "abc stocks", 50);
        when(traderService.buyEquity(trader,equity)).thenReturn("Equity bought succesfully");
        Assertions.assertEquals("Equity bought succesfully",traddingService.buyEquity(trader,equity));
    }

}
