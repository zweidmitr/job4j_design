package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDate;

public class Crisps extends Food {
    public Crisps(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
