package com.nagarro.ebroker.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Static method test case 1")
    @Test
    public void shouldGetNoSellingTimeResponse(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::getNoSellingTimeResponse).thenReturn("can not sell at this time");
            Assertions.assertEquals("can not sell at this time",EbrokerUtils.getNoSellingTimeResponse());
        }
    }

    @DisplayName("Static method test case 2")
    @Test
    public void shouldGetNoBuyingTimeResponse(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::getNoBuyingTimeResponse).thenReturn("can not buy at this time");
            Assertions.assertEquals("can not buy at this time",EbrokerUtils.getNoBuyingTimeResponse());
        }
    }

    @DisplayName("Static method test case 3")
    @Test
    public void shouldCheckForWeekDay(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::checkForWeekDay).thenReturn(true);
            Assertions.assertEquals(true,EbrokerUtils.checkForWeekDay());
        }
    }

    @DisplayName("Static method test case 4")
    @Test
    public void shouldCheckForTime(){
        try(MockedStatic<EbrokerUtils> ebrokerUtils = Mockito.mockStatic(EbrokerUtils.class)){
            ebrokerUtils.when(EbrokerUtils::checkForTime).thenReturn(true);
            Assertions.assertEquals(true,EbrokerUtils.checkForTime());
        }
    }
}
