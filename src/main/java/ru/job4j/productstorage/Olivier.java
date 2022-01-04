package ru.job4j.productstorage;

import java.util.Calendar;

public class Olivier extends Food {
    public Olivier(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
