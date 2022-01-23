package ru.job4j.ood.lsp.carparking;

import java.util.List;

public class ParkCars implements Parking {
    /**
     * park car
     *
     * @param car passengerCar or Truck
     * @return yes/no
     */
    @Override
    public boolean parkCar(Car car) {
        return false;
    }

    /**
     * show park car list
     *
     * @return list park car
     */
    @Override
    public List<Car> getParkCar() {
        return null;
    }
}
