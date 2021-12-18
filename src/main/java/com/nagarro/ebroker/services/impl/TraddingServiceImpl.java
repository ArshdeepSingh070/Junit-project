package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraddingServiceImpl implements TraddingService {

    @Autowired
    TraderService traderService;

    @Autowired
    EquityService equityService;

    @Override
    public void sellTraderEquity(Trader trader, Equity equity) {

       traderService.sellEquity(trader, equity);
    }

    @Override
    public String buyEquity(Trader trader, Equity equity) {

        if (trader.getAvailableFunds() > 20.0) {
            return traderService.buyEquity(trader, equity);
        }{
            return "insufficient funds";
        }
    }
}
