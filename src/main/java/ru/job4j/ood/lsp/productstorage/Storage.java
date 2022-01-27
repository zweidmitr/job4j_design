package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    boolean add(Food food);

    /**
     * получаем список продуктов на складе
     *
     * @return
     */
    List<Food> getFoodList();

    /**
     * зачищаем список продуктов на складе
     */
    void clearFoodList();

    /**
     * рассчитываем время жизни, остаток и % оставшегося времени (для продукта)
     *
     * @param food продукты
     * @return срок годности от текущего момента
     */
    default double checkFood(Food food) {
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
    boolean accept(Food food);
}
