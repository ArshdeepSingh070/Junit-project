package com.nagarro.ebroker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equity")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "availableFunds")
    private double availableFunds;

    @Column(name = "equities")
    private List<Equity> equities;

    public Trader() {
    }

    public Trader(String id, String name, double availableFunds, List<Equity> equities) {
        this.id = id;
        this.name = name;
        this.availableFunds = availableFunds;
        this.equities = equities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        this.availableFunds = availableFunds;
    }

    public List<Equity> getEquities() {
        return equities;
    }

    public void setEquities(List<Equity> equities) {
        this.equities = equities;
    }
}
