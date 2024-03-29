package com.nagarro.ebroker.services;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;

import java.util.List;

public interface TraderService {

    List<Trader> getAllTraders();

    Trader getTraderById(long id);

    Trader createTrader(Trader trader);

    Trader addFunds(long id, double fund);

    String sellEquity(Trader trader, Equity equityId);

    String buyEquity(Trader trader, Equity equity);
}
