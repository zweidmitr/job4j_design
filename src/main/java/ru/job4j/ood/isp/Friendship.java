package ru.job4j.ood.isp;

/**
 * пример нарушения Interface Segregation Principle
 * собвственно все люди разные...
 */
public interface Friendship {
    void trust();

    void interest();

    void time();

    void laugh();

    void money();
}
