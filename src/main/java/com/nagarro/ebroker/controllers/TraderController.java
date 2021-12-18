package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trader")
public class TraderController {

    @Autowired
    TraderService traderService;

    @GetMapping("/{id}")
    public ResponseEntity<Trader> getTraderById(@PathVariable("id") String id){
        ResponseEntity<Trader> traderData = traderService.getTraderById(id);
        if(traderData != null && traderData.getStatusCode().toString().equals(HttpStatus.OK)){
            return traderData;
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createTrader")
    public void createTrader(@RequestBody Trader trader) {
            ResponseEntity<Trader> createdTrader = traderService.createTrader(trader);
    }

    @PutMapping("/addFund/{id}")
    public ResponseEntity<Trader> addFund(@PathVariable("id") String id, @RequestBody double fund) {
        ResponseEntity<Trader> traderData = traderService.addFunds(id, fund);
        return traderData;
    }
}
