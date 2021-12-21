package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import com.nagarro.ebroker.utils.EbrokerValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equity")
public class EquityController {

    @Autowired
    EquityService equityService;

    @GetMapping("/{id}")
    public Equity getEquityById(@PathVariable("id") long id){
        Equity equityData = equityService.getEquityById(id);
        if(equityData != null){
            return equityData;
        }else {
            return null;
        }
    }

    @PostMapping("/addEquity")
    public Equity addEquity(@RequestBody Equity equity) {

        if(EbrokerValidationUtils.checlEquityData(equity)) {
            Equity equityData = equityService.addEquity(equity);
            return equityData;
        }else {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Equity> getAllEquities(){

       List<Equity> equities = equityService.getAllEquities();

        return equities;
    }

}