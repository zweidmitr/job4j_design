package ru.job4j.ood.lsp;

/**
 * 1. Предусловия (Preconditions) не могут быть усилены в подклассе
 * Принцип подстановки Лисков. - пример нарушения, когда наследуемый класс
 * меняет предусловия
 */
public class MineWorker {
    protected double kilogram;

    public MineWorker(double kilogram) {
        this.kilogram = kilogram;
    }

    public boolean dinnerCheck(double kilo) {
        boolean canEat = false;
        if (kilo > 5) {
            canEat = true;
        }
        return canEat;
    }
}

class GoldMiner extends MineWorker {
    public GoldMiner(double kilogram) {
        super(kilogram);
    }

    @Override
    public boolean dinnerCheck(double kilo) {
        boolean canEat = false;
        if (kilo > 1) {
            canEat = true;
        }
        return canEat;
    }
}
