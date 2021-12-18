package com.nagarro.ebroker.controllers;

import com.nagarro.ebroker.dao.EquityRepository;
import com.nagarro.ebroker.model.Equity;
import com.nagarro.ebroker.services.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/equity")
public class EquityController {

    @Autowired
    EquityRepository equityRepository;

    @Autowired
    EquityService equityService;

    @GetMapping("/{id}")
    public ResponseEntity<Equity> getEquityById(@PathVariable("id") String id){
        ResponseEntity<Equity> equityData = equityService.getEquityById(id);
        if(equityData.getStatusCode().toString().equals(HttpStatus.OK)){
            return equityData;
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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