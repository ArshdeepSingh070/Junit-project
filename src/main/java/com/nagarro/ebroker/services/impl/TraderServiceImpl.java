package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.TraderRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderServiceImpl implements TraderService {

    @Autowired
    TraderRepository traderRepository;

    public ResponseEntity<Trader> getTraderById(String id){

        Trader traderData = traderRepository.findById(id).get();
        if(traderData != null){
            return new ResponseEntity<>(traderData, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Trader> createTrader(Trader trader){
        try {
            Trader createdTrader = traderRepository
                    .save(new Trader(trader.getId(), trader.getName(), trader.getAvailableFunds(), null));
            return new ResponseEntity<>(createdTrader, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Trader> addFunds(String id, double fund) {
        Trader traderData = traderRepository.findById(id).get();
        if (traderData != null) {
            double existingFund = traderData.getAvailableFunds();
            traderData.setAvailableFunds(existingFund + fund);
            return new ResponseEntity<>(traderRepository.save(traderData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void sellEquity(Trader trader, Equity equity){
        List<Equity> holdingEquities = trader.getEquities();
        double existingFunds = trader.getAvailableFunds();
        holdingEquities.remove(equity);
        trader.setEquities(holdingEquities);
        trader.setAvailableFunds(existingFunds + equity.getPrice());
        new ResponseEntity<>(traderRepository.save(trader), HttpStatus.OK);
    }

    @Override
    public String buyEquity(Trader trader, Equity equity) {
        double availableFunds = trader.getAvailableFunds();
        List<Equity> existingEquities = trader.getEquities();

        existingEquities.add(equity);
        availableFunds = availableFunds - equity.getPrice();

        trader.setAvailableFunds(availableFunds);
        trader.setEquities(existingEquities);

        new ResponseEntity<>(traderRepository.save(trader), HttpStatus.OK);

        return "Equity bought succesfully";
    }


}
