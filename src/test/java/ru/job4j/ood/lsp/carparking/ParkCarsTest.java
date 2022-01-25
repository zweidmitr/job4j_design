package ru.job4j.ood.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkCarsTest {
    PassengerCar pCar1 = new PassengerCar();
    PassengerCar pCar2 = new PassengerCar();
    Truck tCar1 = new Truck(2);
    Truck tCar2 = new Truck(3);
    Truck tCar3 = new Truck(6);

    @Test
    public void whenPark2pCarAnd1tCar() {
        ParkCars parking = new ParkCars(2, 2);
        assertTrue(parking.parkCar(pCar1));
        assertTrue(parking.parkCar(pCar2));
        assertTrue(parking.parkCar(tCar1));
    }

    @Test
    public void whenTruckOnPassPlace() {
        ParkCars parking = new ParkCars(2, 4);
        assertTrue(parking.parkCar(pCar1));
        assertTrue(parking.parkCar(tCar1));
        assertTrue(parking.parkCar(tCar2));
    }

    @Test
    public void whenPark2tCarOnePassengerCarExcess() {
        ParkCars parking = new ParkCars(0, 5);
        assertTrue(parking.parkCar(tCar1));
        assertTrue(parking.parkCar(tCar2));
        assertFalse(parking.parkCar(pCar2));
    }

    @Test
    public void whenPark1pCarAnd3tCarOneTruckExcess() {
        ParkCars parking = new ParkCars(5, 6);
        assertTrue(parking.parkCar(pCar1));
        assertTrue(parking.parkCar(tCar1));
        assertTrue(parking.parkCar(tCar2));
        assertFalse(parking.parkCar(tCar3));
    }

    @Test
    public void whenParkingIsClosed() {
        ParkCars parking = new ParkCars(0, 0);
        assertFalse(parking.parkCar(pCar2));
        assertFalse(parking.parkCar(tCar1));
    }
}