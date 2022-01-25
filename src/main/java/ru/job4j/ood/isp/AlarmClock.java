package ru.job4j.ood.isp;

/**
 * пример нарушения Interface Segregation Principle
 * в разных типах будильников разные методы пробуждения
 * что-то может отсутвовать
 */
public interface AlarmClock {

    void sound();

    void vibration();

    void turnLight();

}
