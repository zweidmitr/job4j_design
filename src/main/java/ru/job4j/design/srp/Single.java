package ru.job4j.design.srp;

public class Single {
    private static Single one;

    private Single() {
    }

    public static Single getOne() { // #3
        if (one == null) {
            one = new Single();
        }
        return one;
    }
}
