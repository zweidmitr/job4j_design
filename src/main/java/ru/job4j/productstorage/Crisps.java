package ru.job4j.productstorage;

import java.time.LocalDate;
import java.util.Calendar;

public class Crisps extends Food {
    public Crisps(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
