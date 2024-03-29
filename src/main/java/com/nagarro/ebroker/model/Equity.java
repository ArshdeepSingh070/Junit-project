package com.nagarro.ebroker.model;



import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "equity")
public class Equity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public Equity() {
    }

    public Equity(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", name=" + name + ", desc=" + description + ", price=" + price + "]";
    }

}
