package ru.job4j.ood.lsp.carparking;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkCarsTest {
    PassengerCar pCar1 = new PassengerCar();
    PassengerCar pCar2 = new PassengerCar();
    Truck tCar1 = new Truck(2);
    Truck tCar2 =  new Truck(3);

    @Test
    @Ignore
    public void whenPark2pCarAnd1tCar(){
        ParkCars parking = new ParkCars();
        assertTrue(parking.parkCar(pCar1));
        assertTrue(parking.parkCar(pCar2));
        assertTrue(parking.parkCar(tCar1));
    }

    @Test
    @Ignore
    public void whenPark2tCar(){
        ParkCars parking = new ParkCars();
        assertTrue(parking.parkCar(tCar1));
        assertTrue(parking.parkCar(tCar2));
    }

}