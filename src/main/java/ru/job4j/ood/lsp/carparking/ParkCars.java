package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkCars implements Parking {
    /**
     * количество мест, необходимых для парковки
     */
    private int sizePassCar;
    private int sizeTruck;

    private final List<Car> parkingLot = new ArrayList<>();

    public ParkCars(int sizePassCar, int sizeTruck) {
        this.sizePassCar = sizePassCar;
        this.sizeTruck = sizeTruck;
    }

    /**
     * parking passengerCar or Truck or ...
     *
     * @param car passengerCar or Truck
     * @return yes/no
     */
    @Override
    public boolean parkCar(Car car) {
        boolean result = false;
        int carSize = car.getSize();
        if (carSize == 1 && sizePassCar >= 1) {
            parkingLot.add(car);
            sizePassCar--;
            result = true;
        }
        if (carSize > 1) {
            if (sizeTruck > 0) {
                parkingLot.add(car);
                sizeTruck--;
                return true;
            } else if (carSize <= sizePassCar) {
                parkingLot.add(car);
                sizePassCar -= carSize;
                return true;
            }
        }
        return result;
    }

    /**
     * show park car list
     *
     * @return list park car
     */
    @Override
    public List<Car> getParkCar() {
        ArrayList<Car> park = new ArrayList<>(parkingLot);
        return park;
    }
}
