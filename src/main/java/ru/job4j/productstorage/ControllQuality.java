package ru.job4j.productstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControllQuality {
    /**
     * Хранилище для продукта
     */
    private final List<Storage> storageList;

    public ControllQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    /**
     * контроль и размещение продуктов
     *
     * @param food
     */
    public void controll(Food food) {
        for (Storage storage : storageList) {
            storage.add(food);
        }
    }
}
