package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.EquityRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquityServiceImpl implements EquityService {

    @Autowired
    private EquityRepository equityRepository;

    @Override
    public Equity getEquityById(long id) {
        Optional<Equity> equityData = equityRepository.findById(id);
        if(equityData != null){
            return equityData.get();
        }else {
            return null;
        }
    }

    @Override
    public Equity addEquity(Equity equity) {
        try {
            Equity addedEquity = equityRepository
                    .save(new Equity(equity.getName(), equity.getDescription(), equity.getPrice()));
            return new ResponseEntity<>(addedEquity, HttpStatus.CREATED).getBody();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Equity> getAllEquities() {
        try {
            List<Equity> equities = new ArrayList<Equity>();

            equityRepository.findAll().forEach(equities :: add);

            if (equities.isEmpty()) {
                return (List<Equity>) new ResponseEntity<>(HttpStatus.NO_CONTENT).getBody();
            }

            return new ResponseEntity<>(equities, HttpStatus.OK).getBody();
        } catch (Exception e) {
            return (List<Equity>) new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR).getBody();
        }
    }
}
