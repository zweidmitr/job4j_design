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
        } else if (carSize > 1 && sizeTruck >= carSize) {
            parkingLot.add(car);
            sizeTruck -= carSize;
            result = true;
        } else if (carSize > sizeTruck && (carSize - sizeTruck) <= sizePassCar) {
            int temp = carSize - sizeTruck;
            sizeTruck = 0;
            sizePassCar -= temp;
            parkingLot.add(car);
            result = true;
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
