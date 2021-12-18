package com.nagarro.ebroker.services;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;
import org.springframework.http.ResponseEntity;

public interface TraderService {

    ResponseEntity<Trader> getTraderById(String id);

    ResponseEntity<Trader> createTrader(Trader trader);

    ResponseEntity<Trader> addFunds(String id, double fund);

    void sellEquity(Trader trader, Equity equityId);

    String buyEquity(Trader trader, Equity equity);
}
