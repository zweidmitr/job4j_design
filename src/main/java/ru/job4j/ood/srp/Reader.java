package ru.job4j.ood.srp;

import java.util.List;

/**
 * реализация нарушения SRP
 * - в одном интерфейсе две различных цели
 */
public interface Reader<T> {
    List<T> books(String names);

    void send(List<T> openBooks);
}
