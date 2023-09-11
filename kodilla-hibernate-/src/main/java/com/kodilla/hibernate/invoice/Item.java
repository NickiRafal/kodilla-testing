package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity
@Table(name = "ITEM")
public class Item {
    private int idItem;
    private Invoice invoice;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public Item(Product product, BigDecimal price) {
        this.product = product;
        this.price = price;
    }
    public Item(){

    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID_ITEM")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }


    @ManyToOne
    @JoinColumn(name = "IDPRODUCT")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }
    @Column(name = "PRICE")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
