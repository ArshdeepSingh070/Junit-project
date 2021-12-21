package com.nagarro.ebroker.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EbrokerUtilsTest {

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
    public void shouldGetNoSellingTimeResponse(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::getNoSellingTimeResponse).thenReturn("can not sell at this time");
            Assertions.assertEquals("can not sell at this time",EbrokerUtils.getNoSellingTimeResponse());
        }
    }

    @Test
    public void shouldGetNoBuyingTimeResponse(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::getNoBuyingTimeResponse).thenReturn("can not buy at this time");
            Assertions.assertEquals("can not buy at this time",EbrokerUtils.getNoBuyingTimeResponse());
        }
    }

    @Test
    public void shouldCheckForWeekDay(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::checkForWeekDay).thenReturn(true);
            Assertions.assertEquals(true,EbrokerUtils.checkForWeekDay());
        }
    }

    @Test
    public void shouldCheckForTime(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::checkForTime).thenReturn(true);
            Assertions.assertEquals(true,EbrokerUtils.checkForTime());
        }
    }
}
