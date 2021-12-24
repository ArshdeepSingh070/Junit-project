package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import com.nagarro.ebroker.utils.EbrokerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TraddingController {

    public static double MINIMUM_FUNDS_TO_BUY = 20;

    @Autowired
    TraderService traderService;

    @Autowired
    EquityService equityService;

    @Autowired
    TraddingService traddingService;

    @PostMapping("/sell/trader/{traderId}/equity/{equityId}")
    public String sellEquity(@RequestParam("traderId") long traderId, @RequestParam("equityId") long equityId){

        Trader trader = traderService.getTraderById(traderId);
        Equity equity = equityService.getEquityById(equityId);

        List<Equity> traderEquities = getTraderOnHoldEquities(trader);

        for(Equity traderEquity : traderEquities){
            if(traderEquity.getName().equals(equity.getName())){
                String response = traddingService.sellTraderEquity(trader,equity);
                return response;
            }
        }

        return EbrokerUtils.getNoEquityHoldingResponse();

    }

    @PostMapping("/buy/trader/{traderId}/equity/{equityId}")
    public String buyEquity(@RequestParam("traderId") long traderId, @RequestParam("equityId") long equityId){
        Trader trader = traderService.getTraderById(traderId);
        Equity equity = equityService.getEquityById(equityId);

        if(trader != null && trader.getAvailableFunds() > MINIMUM_FUNDS_TO_BUY) {
            String response = traddingService.buyEquity(trader, equity);
            return response;
        }else{
            return EbrokerUtils.getInsufficientFundResponse();
        }
    }

    private List<Equity> getTraderOnHoldEquities(Trader trader){
        return trader.getEquities();
    }
}
