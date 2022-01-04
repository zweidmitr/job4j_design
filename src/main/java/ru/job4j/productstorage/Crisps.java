package ru.job4j.productstorage;

import java.util.Calendar;

public class Crisps extends Food {
    public Crisps(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
