package ru.job4j.ood.lsp.carparking;

public class PassengerCar implements Car {
    public final int size;

    public PassengerCar() {
        this.size = 1;
    }

    public int getSize() {
        return this.size;
    }
}
