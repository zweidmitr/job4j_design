package ru.job4j.ood.dip;

import java.util.HashMap;
import java.util.Map;

/**
 * Примеры нарушение DIP -  зависим от реализации
 */
public class Maps {
    private Map<Integer, Integer> mapik = new HashMap<>();

    public boolean addToMaps() {
        mapik.put(6432121, 413165);
        System.out.println("добавили отметку на карту");
        return true;
    }
}
