package ru.job4j.ood.isp;

/**
 * пример нарушения Interface Segregation Principle
 * у всех разные возможности приготовления еды дома
 */
public interface CookAtHome {

 void gasStove();

 void electricStove();

 void microwave();

 void lazyLunch();
}
