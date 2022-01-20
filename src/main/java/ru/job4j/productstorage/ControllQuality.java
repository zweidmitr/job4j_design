package ru.job4j.productstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControllQuality {
    /**
     * контроль и размещение продуктов
     * @param food
     */
 public void controll(Food food) {

 }

    /**
     * рассчитываем время жизни, остаток и % оставшегося времени (для продукта)
     *
     * @param food продукты
     * @return срок годности от текущего момента
     */
    public double checkFood(Food food) {
        double time = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double remain = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        return remain / time * 100;
    }
}
