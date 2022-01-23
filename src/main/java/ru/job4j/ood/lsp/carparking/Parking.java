package ru.job4j.ood.lsp.carparking;

import java.util.List;

public interface Parking {
    /**
     * park car
     * @param car passengerCar or Truck
     * @return yes/no
     */
    boolean parkCar(Car car);

    /**
     *  show park car list
     * @return list park car
     */
    List<Car> getParkCar();

}
