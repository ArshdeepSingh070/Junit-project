package com.nagarro.ebroker.services;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.model.Trader;

public interface TraddingService {

    void sellTraderEquity(Trader trader, Equity equity);

    String buyEquity(Trader trader, Equity equity);
}
