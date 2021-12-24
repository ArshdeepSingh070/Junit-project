package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.TraderRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TraderServiceImplTest {

    @InjectMocks
    private TraderServiceImpl traderService;

    @Mock
    private TraderRepository traderRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Get trader by id from repository")
    @Test
    public void shouldGetTraderById(){
        Trader trader = new Trader("arsh",100, null);
        when(traderRepository.findById(1L)).thenReturn(Optional.of(trader));
        assertEquals(trader, traderService.getTraderById(1L));
    }

    @DisplayName("Should not return any trader")
    @Test
    public void shouldNotGetTraderById(){
        when(traderRepository.findById(1L)).thenReturn(null);
        assertNull(traderService.getTraderById(1L));
    }

    @DisplayName("Should add new trader")
    @Test
    public void shouldCreateTrader(){
        Trader trader = new Trader("arsh",100, null);
        when(traderRepository.save(trader)).thenReturn(trader);
        traderService.createTrader(trader);
        verify(traderRepository,times(1)).save(trader);
    }

    @DisplayName("Should not add trdaer in repo")
    @Test
    public void shouldNotCreateTrader(){
        Assertions.assertThrows(RuntimeException.class, ()-> traderService.createTrader(null));
    }

    @DisplayName("Should add funds in trader's account")
    @Test
    public void shouldAddFunds(){
        Trader trader = new Trader("arsh",100, null);
        when(traderRepository.findById(1L)).thenReturn(Optional.of(trader));
        when(traderRepository.save(trader)).thenReturn(trader);
        assertNotNull(traderService.addFunds(1l,100));
        assertEquals(200,trader.getAvailableFunds());
    }

    @DisplayName("Should sell equity if in holding")
    @Test
    public void shouldSellEquity(){
        List<Equity> equityList = new ArrayList<>();
        Equity equity = new Equity("abc","abc stock",100);
        equityList.add(equity);
        Trader trader = new Trader("arsh",1000.0,equityList);
        when(traderRepository.save(trader)).thenReturn(trader);
        traderService.sellEquity(trader,equity);
        verify(traderRepository, times(1)).save(trader);
    }

    @DisplayName("Should buy equity if funds present")
    @Test
    public void shouldBuyEquity(){
        Equity equity = new Equity("abc","abc stock",100);
        Trader trader = new Trader("arsh",1000.0,null);
        when(traderRepository.save(trader)).thenReturn(trader);
        traderService.buyEquity(trader,equity);
        verify(traderRepository, times(1)).save(trader);
    }
}
