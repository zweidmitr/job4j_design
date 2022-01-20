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
}
