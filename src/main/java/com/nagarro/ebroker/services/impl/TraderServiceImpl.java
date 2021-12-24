package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.TraderRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import com.nagarro.ebroker.services.TraderService;
import com.nagarro.ebroker.utils.EbrokerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraderServiceImpl implements TraderService {

    @Autowired
    TraderRepository traderRepository;

    public Trader getTraderById(long id){

        Optional<Trader> traderData = traderRepository.findById(id);
        if(traderData != null){
            return new ResponseEntity<>(traderData, HttpStatus.OK).getBody().get();
        }else {
            return null;
        }

    }

    public Trader createTrader(Trader trader){
        try {
            if(trader != null){
                Trader createdTrader = traderRepository
                        .save(trader);
                return new ResponseEntity<>(createdTrader, HttpStatus.CREATED).getBody();
            }else{
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Trader> getAllTraders() {
        List<Trader> traders = traderRepository.findAll();
        if (traders == null) {
            return null;
        }
        return new ResponseEntity<>(traders, HttpStatus.OK).getBody();
    }

    @Override
    public Trader addFunds(long id, double fund) {
        Trader traderData = traderRepository.findById(id).get();
        if (traderData != null) {
            double existingFund = traderData.getAvailableFunds();
            traderData.setAvailableFunds(existingFund + fund);
            return new ResponseEntity<>(traderRepository.save(traderData), HttpStatus.OK).getBody();
        } else {
            return (Trader) new ResponseEntity<>(HttpStatus.NOT_FOUND).getBody();
        }
    }

    public String sellEquity(Trader trader, Equity equity){
        List<Equity> holdingEquities = trader.getEquities();
        double existingFunds = trader.getAvailableFunds();
        holdingEquities.remove(equity);
        trader.setEquities(holdingEquities);
        trader.setAvailableFunds(existingFunds + equity.getPrice());
        new ResponseEntity<>(traderRepository.save(trader), HttpStatus.OK);
        return EbrokerUtils.getSoldResponse();
    }

    @Override
    public String buyEquity(Trader trader, Equity equity) {
        double availableFunds = trader.getAvailableFunds();
        List<Equity> existingEquities;
        if(trader.getEquities() == null){
            existingEquities = new ArrayList<>();
        }else{
            existingEquities = trader.getEquities();
        }
        existingEquities.add(equity);
        availableFunds = availableFunds - equity.getPrice();

        trader.setAvailableFunds(availableFunds);
        trader.setEquities(existingEquities);

        new ResponseEntity<>(traderRepository.save(trader), HttpStatus.OK);

        return EbrokerUtils.getEquityBoughhtResponse();
    }


}
