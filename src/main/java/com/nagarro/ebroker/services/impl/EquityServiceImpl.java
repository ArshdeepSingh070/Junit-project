package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.EquityRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
            List<Equity> equities = equityRepository.findAll();
            if (equities == null) {
                return null;
            }
            return new ResponseEntity<>(equities, HttpStatus.OK).getBody();
    }
}
