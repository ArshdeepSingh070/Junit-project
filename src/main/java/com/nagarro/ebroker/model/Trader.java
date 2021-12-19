package com.nagarro.ebroker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equity")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "availableFunds")
    private double availableFunds;

    @ElementCollection
    @CollectionTable(
            name="Equity",
            joinColumns=@JoinColumn(name="id")
    )
    private List<Equity> equities;

    /*@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "equity")
    private Set<Equity> equities = new HashSet<>();*/

    public Trader(String arsh, double v, List<Equity> equityList) {
    }

    public Trader(long id, String name, double availableFunds, List<Equity> equities) {
        this.id = id;
        this.name = name;
        this.availableFunds = availableFunds;
        this.equities = equities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
