package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import com.nagarro.ebroker.utils.EbrokerValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trader")
public class TraderController {

    @Autowired
    TraderService traderService;

    @GetMapping("/{id}")
    public Trader getTraderById(@PathVariable("id") long id){
        Trader traderData = traderService.getTraderById(id);
        if(traderData != null){
            return traderData;
        }else {
            return null;
        }
    }

    @PostMapping("/createTrader")
    public Trader createTrader(@RequestBody Trader trader) {

      if(EbrokerValidationUtils.checkTraderData(trader)) {
          Trader createdTrader = traderService.createTrader(trader);
          return createdTrader;
      }else{
          return null;
      }
    }

    @PutMapping("/addFund/{id}")
    public Trader addFund(@PathVariable("id") long id, @RequestBody double fund) {
        Trader traderData = traderService.addFunds(id, fund);
        return traderData;
    }

    @GetMapping("/getAll")
    public List<Trader> getAllEquities(){

        List<Trader> traders = traderService.getAllTraders();

        return traders;
    }
}
