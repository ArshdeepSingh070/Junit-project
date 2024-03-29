package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.EquityRepository;
import com.nagarro.ebroker.model.Equity;
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

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EquityServiceImplTest {
    @InjectMocks
    private EquityServiceImpl equityService;

    @Mock
    private EquityRepository equityRepository;

    @Mock
    private Equity equity;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Should get equity for given id")
    @Test
    public void shouldGetEquityById(){
        when(equityRepository.findById((long) 1)).thenReturn(Optional.of(new Equity("abc", "abc stock", 100)));
        assertNotNull(equityService.getEquityById(1));
    }

    @DisplayName("Should not get equity if there is not equity against given id")
    @Test
    public void shouldNotGetEquityById(){
        when(equityRepository.findById((long) 1)).thenReturn(null);
        assertNull(equityService.getEquityById(1));
    }

    @DisplayName("Add equity")
    @Test
    public void shouldAddEquity(){
        Equity equity = new Equity("abc","abc stock",100);
        when(equityRepository.save(any(Equity.class))).thenReturn(equity);
        assertNotNull(equityService.addEquity(equity));
        assertNotNull(equity.getId());
    }

    @DisplayName("Should add equity and should throw exception if data is null")
    @Test
    public void shouldNotAddEquity(){
        Assertions.assertThrows(RuntimeException.class, ()-> equityService.addEquity(null));
    }

    @DisplayName("Should return all the equities present")
    @Test
    public void shouldGetAllEquities(){
        List<Equity> equityList = new ArrayList<>();
        Equity equity1 = new Equity("abc","abc stock",100);
        Equity equity2 = new Equity("xyz","xyz stock",100);
        equityList.add(equity1);
        equityList.add(equity2);
        when(equityRepository.findAll()).thenReturn(equityList);
        assertNotNull(equityService.getAllEquities());
        assertEquals(2,equityService.getAllEquities().size());
    }

    @DisplayName("Should return null if no equity is there")
    @Test
    public void shouldReturnNullIfNoEquities(){
        when(equityRepository.findAll()).thenReturn(null);
        assertNull(equityService.getAllEquities());
    }
}
