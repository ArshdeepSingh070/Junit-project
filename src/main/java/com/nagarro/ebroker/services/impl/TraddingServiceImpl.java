package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import com.nagarro.ebroker.utils.EbrokerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraddingServiceImpl implements TraddingService {

    @Autowired
    TraderService traderService;

    @Override
    public String sellTraderEquity(Trader trader, Equity equity) {

       if(EbrokerUtils.checkForWeekDay() && EbrokerUtils.checkForTime()) {
           String response = traderService.sellEquity(trader, equity);
           return response;
       }else{
           return EbrokerUtils.getNoSellingTimeResponse();
       }
    }

    @Override
    public String buyEquity(Trader trader, Equity equity) {

        if(EbrokerUtils.checkForWeekDay() && EbrokerUtils.checkForTime()) {
                return traderService.buyEquity(trader, equity);
        }else{
               return EbrokerUtils.getNoBuyingTimeResponse();
        }
    }
}
