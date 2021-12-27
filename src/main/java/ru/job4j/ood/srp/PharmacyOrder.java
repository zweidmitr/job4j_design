package ru.job4j.ood.srp;

import ru.job4j.linkedlist.List;

/**
 * реализация нарушения SRP
 * - метод addToOrder - обавляет товар в список
 * - метод  countInWareHouse - определяет остаток и выводит на экран
 */
public class PharmacyOrder {
    private List<String> order;

    public void addToOrder(String name) {
        order.add(name);
    }

    int countInWareHouse(int count) {
        System.out.println(count--);
        return count;
    }
}
