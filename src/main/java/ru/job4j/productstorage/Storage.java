package ru.job4j.productstorage;

import java.util.List;

/**
 * для работы с разными хранилищ.
 */
public interface Storage {

    /**
     * добавляет продукты в хранилище
     *
     * @param food продукты
     */
    void add(Food food);

    /**
     * получаем список продуктов на складе
     *
     * @return
     */
    List<Food> getFoodList();

    /**
     * рассчитываем время жизни, остаток и % оставшегося времени (для продукта)
     *
     * @param food продукты
     * @return срок годности от текущего момента
     */
    double checkFood(Food food);

    /**
     * данный метод проверяет может ли хранилище принять продукт
     *
     * @param food продукты
     * @return подходит ли продукт данному хранилищу
     */
    boolean accept(Food food);
}
