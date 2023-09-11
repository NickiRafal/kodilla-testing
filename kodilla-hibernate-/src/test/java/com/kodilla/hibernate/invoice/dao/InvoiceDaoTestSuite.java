package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        // Given
        Product product = new Product();
        product.setName("Produkt 1 ");

        Item item1 = new Item();
        item1.setPrice(BigDecimal.valueOf(50));
        item1.setQuantity(2);
        item1.setValue(item1.getPrice().multiply(BigDecimal.valueOf(item1.getQuantity())));
        item1.setProduct(product);

        Item item2 = new Item();
        item2.setPrice(BigDecimal.valueOf(100));
        item2.setQuantity(5);
        item2.setValue(item2.getPrice().multiply(BigDecimal.valueOf(item2.getQuantity())));
        item2.setProduct(product);

        Invoice invoice = new Invoice();
        invoice.setNumber("INV / 2023 / 001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        // When
        productDao.save(product);
        invoiceDao.save(invoice);

        int invoiceId = invoice.getId_Invoice();

        // Then
        assertNotNull(invoiceId);

        // Clean-up
        itemDao.deleteAll();
        invoiceDao.deleteById(invoiceId);
        productDao.deleteAll();
    }
}
