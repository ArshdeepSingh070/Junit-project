package com.nagarro.ebroker.dao;

import com.nagarro.ebroker.model.Equity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquityRepository extends JpaRepository<Equity, Long> {

    List<Equity> getEquityById(Long id);

    List<Equity> getEquityByName(String name);
}
