package ru.job4j.productstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
     * рассчитываем время жизни, остаток и % оставшегося времени (для продукта)
     *
     * @param food продукты
     * @return срок годности от текущего момента
     */
    @Override
    public double checkFood(Food food) {
        double time = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double remain = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        return remain / time * 100;
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
