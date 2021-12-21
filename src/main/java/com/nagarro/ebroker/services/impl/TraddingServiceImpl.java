package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import com.nagarro.ebroker.utils.EbrokerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraddingServiceImpl implements TraddingService {

    @Autowired
    TraderService traderService;

    @Autowired
    EquityService equityService;

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

    /*private boolean checkForWeekDay(){
        Calendar currentDate = Calendar.getInstance();
        int dayOfWeek = currentDate.get (Calendar.DAY_OF_WEEK);
        boolean isWeekday = ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY));
        if(!isWeekday){
            return false;
        }
        return true;
    }
*/
    /*private boolean checkForTime() {

        LocalTime morning = LocalTime.of(0, 0, 0);
        LocalTime evening = LocalTime.of(23, 0, 0);

        LocalTime nowTime = LocalTime.now();

        if (nowTime.isAfter(morning) && nowTime.isBefore(evening)) {
            return true;
        } else {
            return false;
        }
    }*/
}
