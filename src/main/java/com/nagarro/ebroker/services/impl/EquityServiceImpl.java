package com.nagarro.ebroker.services.impl;

import com.nagarro.ebroker.dao.EquityRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquityServiceImpl implements EquityService {

    @Autowired
    private EquityRepository equityRepository;

    @Override
    public Equity getEquityById(String id) {
        Equity equityData = equityRepository.findById(id).get();
        /*if(equityData != null){
            return new ResponseEntity<>(equityData, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return equityData;
    }

    @Override
    public ResponseEntity<Equity> addEquity(Equity equity) {
        try {
            Equity addedEquity = equityRepository
                    .save(new Equity(equity.getId(), equity.getName(), equity.getDescription(), equity.getPrice()));
            return new ResponseEntity<>(addedEquity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Equity>> getAllEquities() {
        /*try {
            List<Equity> equities = new ArrayList<Equity>();

            equityRepository.findAll().forEach(equities :: add);

            if (equities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(equities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
        return null;
    }
}
