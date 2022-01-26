package ru.job4j.ood.isp.menu;

/**
 * цель: напечатать свою строку при выборе конкретного меню
 */
public class ActionMenu implements Action {
    private String test;

    public ActionMenu(String test) {
        this.test = test;
    }

    @Override
    public void act() {
        System.out.println(test);
    }
}
