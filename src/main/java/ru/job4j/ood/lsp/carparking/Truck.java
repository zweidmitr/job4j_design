package ru.job4j.ood.lsp.carparking;

public class Truck implements Car {
    public final int size;

    public Truck(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
