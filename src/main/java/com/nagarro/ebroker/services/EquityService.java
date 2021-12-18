package com.nagarro.ebroker.services;

import com.nagarro.ebroker.model.Equity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquityService {

    ResponseEntity<Equity> getEquityById(String id);

    ResponseEntity<Equity> addEquity(Equity equity);

    public ResponseEntity<List<Equity>> getAllEquities();
}
