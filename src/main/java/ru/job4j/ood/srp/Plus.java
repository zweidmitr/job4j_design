package ru.job4j.ood.srp;

/**
 * реализация нарушения SRP
 * - метод plus - складывает числа
 * - метод  show - выводит на экран
 */
public class Plus {

    public Plus() {
    }

    public int plus(int one, int two) {
        return one + two;
    }

    public void show(int one, int two) {
        System.out.println("answer: " + one + two);
    }
}
