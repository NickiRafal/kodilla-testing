package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "INVOICE")
public class Invoice {
    private int id_Invoice;
    private String number;
    private List <Item> items = new ArrayList<>();

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }
    public Invoice(){

    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID_INVOICE")
    public int getId_Invoice() {
        return id_Invoice;
    }

    public void setId_Invoice(int id_Invoice) {
        this.id_Invoice = id_Invoice;
    }
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
