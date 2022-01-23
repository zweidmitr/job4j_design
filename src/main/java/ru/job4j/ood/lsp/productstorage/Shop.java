package ru.job4j.ood.lsp.productstorage;

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
    public boolean add(Food food) {
        boolean result = accept(food);
        if (result) {
            foodList.add(food);
        }
        return result;
    }

    /**
     * должен возвращать копию (чтобы никто не мог обойти проверку и добавить,
     * к примеру, просроченный продукт напрямую в лист Shop)
     *
     * @return копию листа
     */
    @Override
    public List<Food> getFoodList() {
        List<Food> copyList = new ArrayList<>(foodList);
        return copyList;
    }

    /**
     * данный метод проверяет может ли хранилище принять продукт
     *
     * @param food продукты
     * @return подходит ли продукт данному хранилищу
     */
    public boolean accept(Food food) {
        boolean result = false;
        double tempCheck = checkFood(food);
        if (tempCheck >= 25 && tempCheck <= 75) {
            result = true;
        } else if (tempCheck > 0 && tempCheck < 25) {
            food.setPrice(food.getPrice() - food.getDiscount());
            result = true;
        }
        return result;
    }
}
