package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.services.TraddingService;
import com.nagarro.ebroker.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TraddingController {

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

        /*if(trader.getStatusCode().toString().equals(HttpStatus.NOT_FOUND) || equity.getStatusCode().toString().equals(HttpStatus.NOT_FOUND)){
            return "this trader/equity is not present";
        }*/

        List<Equity> traderEquities = getTraderOnHoldEquities(trader);

        for(Equity traderEquity : traderEquities){
            if(traderEquity.getId() == equity.getId()){
                traddingService.sellTraderEquity(trader,equity);
                return "Equity is sold successfully";
            }
        }

        return "No Equity to sell";

    }

    @PostMapping("/buy/trader/{traderId}/equity/{equityId}")
    public String buyEquity(@RequestParam("traderId") long traderId, @RequestParam("equityId") long equityId){
        Trader trader = traderService.getTraderById(traderId);
        Equity equity = equityService.getEquityById(equityId);

        /*if(trader.getStatusCode().toString().equals(HttpStatus.NOT_FOUND) || equity.getStatusCode().toString().equals(HttpStatus.NOT_FOUND)){
            return "this trader/equity is not present";
        }*/
        String response = traddingService.buyEquity(trader, equity);

        return response;
    }

    private List<Equity> getTraderOnHoldEquities(Trader trader){
        return trader.getEquities();
    }
}
