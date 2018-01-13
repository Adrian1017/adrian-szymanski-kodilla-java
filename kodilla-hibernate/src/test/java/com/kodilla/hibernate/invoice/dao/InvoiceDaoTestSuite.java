package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //GIVEN
        Product paperclip = new Product("paperclip");
        Item item1 = new Item(new BigDecimal(2), 20000, new BigDecimal(40000));
        Item item2 = new Item(new BigDecimal(2), 30000, new BigDecimal(60000));
        Invoice invoice = new Invoice("130120171");
        paperclip.getItems().add(item1);
        paperclip.getItems().add(item2);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setProduct(paperclip);
        item2.setProduct(paperclip);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //WHEN
        invoiceDao.save(invoice);
        int id = invoice.getId();
        //THEN
        Assert.assertNotEquals(0, id);
        //CLEAN UP
        invoiceDao.delete(id);
    }
}