package com.example.proj.db;

import javax.persistence.*;

@Entity
@Table(name = "product_jpa")
public class ProductJPA {
    @Id
    @Column(name="ProductName", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Price", nullable = false)
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}