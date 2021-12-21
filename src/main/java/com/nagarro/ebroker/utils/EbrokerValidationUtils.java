package com.nagarro.ebroker.utils;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;

public class EbrokerValidationUtils {

    public static boolean checkTraderData(Trader trader){
        if(trader != null){
            return true;
        }else{
            throw new RuntimeException();
        }
    }

    public static boolean checlEquityData(Equity equity){
        if(equity != null){
            return true;
        }else{
            throw new RuntimeException();
        }
    }
}
