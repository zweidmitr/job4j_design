package ru.job4j.ood.lsp.productstorage;

import java.util.ArrayList;
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
     * метод извлекает все продукты и перераспределяет с помощью метода relocate()
     */
    public void resort() {
        List<Food> allFood = new ArrayList<>();
        for (Storage store : storageList) {
            allFood.addAll(store.getFoodList());
            store.clearFoodList();
        }
        for (Food food : allFood) {
            relocate(food);
        }
    }

    /**
     * распределяет еду по хранилищам
     *
     * @param food
     */
    public void relocate(Food food) {
        for (Storage store : storageList) {
            store.add(food);
        }
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
