package com.nagarro.ebroker.dao;

import com.nagarro.ebroker.model.Equity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class EquityRepositoryTest {

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        int i = 10;
        Assertions.assertNotNull(i);
    }

    @Test
    @Rollback(false)
    public void shouldTestSaveByRepository()
    {
        EquityRepository equityRepository = Mockito.mock(EquityRepository.class);
        Equity equity = new Equity();
        equity.setName("abc");
        equity.setDescription("abc stock");
        equity.setPrice(100);
        equityRepository.save(equity);
        assertNotNull(equity.getId());
    }
}
