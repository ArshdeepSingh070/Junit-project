package com.nagarro.ebroker.dao;

import com.nagarro.ebroker.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, String> {

    Trader getTraderById();

}
