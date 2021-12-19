package com.nagarro.ebroker.services;

import com.nagarro.ebroker.model.Equity;

import java.util.List;

public interface EquityService {

    Equity getEquityById(long id);

    Equity addEquity(Equity equity);

    List<Equity> getAllEquities();
}
