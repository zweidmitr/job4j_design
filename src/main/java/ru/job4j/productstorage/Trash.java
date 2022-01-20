package ru.job4j.productstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Условие: Если срок годности вышел. Отправить продукт в мусорку.
 */
public class Trash implements Storage {
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
