package ru.job4j.productstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Условие если срок годности от 25% до 75% направить в Shop
 */
public class Shop implements Storage {
    /**
     * тут храним продукты
     */
    private final List<Food> foodList = new ArrayList<>();

    /**
     * добавляем в хранилище
     *
     * @param food продукты
     */
    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }
}
