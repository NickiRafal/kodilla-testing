package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCT")
public class Product {
    private int idProduct;
    private String name;

    public Product(String name) {
        this.name = name;
    }
    public Product(){

    }
    @Id
    @GeneratedValue
    @NotNull
    public int getId() {
        return idProduct;
    }

    public void setId(int id) {
        this.idProduct = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
