package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equity")
public class EquityController {

    @Autowired
    EquityService equityService;

    @GetMapping("/{id}")
    public Equity getEquityById(@PathVariable("id") String id){
        Equity equityData = equityService.getEquityById(id);
        if(equityData != null){
            return equityData;
        }else {
            return null;
        }
    }

    @PostMapping("/addEquity")
    public ResponseEntity<Equity> addEquity(@RequestBody Equity equity) {

        ResponseEntity<Equity> equityData = equityService.addEquity(equity);

        return equityData;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Equity>> getAllEquities(){

        ResponseEntity<List<Equity>> equities = equityService.getAllEquities();

        return equities;
    }

}