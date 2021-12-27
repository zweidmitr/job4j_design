package ru.job4j.design.srp;

public class Single {
    private static Single one;

    private Single() {
    }

    public static Single getOne() {
        if (one == null) {
            one = new Single();
        }
        return one;
    }
}
