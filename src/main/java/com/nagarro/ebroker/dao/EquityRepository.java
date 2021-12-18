package com.nagarro.ebroker.dao;

import com.nagarro.ebroker.model.Equity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquityRepository extends JpaRepository<Equity, String> {
    List<Equity> getAllEquities();

    List<Equity> getEquityById(Long id);

    List<Equity> getEquityByName(String name);
}
