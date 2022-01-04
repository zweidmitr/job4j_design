package ru.job4j.productstorage;

import java.util.Calendar;

public class Chilli extends Food {
    public Chilli(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
