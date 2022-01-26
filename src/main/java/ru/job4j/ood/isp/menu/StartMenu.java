package ru.job4j.ood.isp.menu;

import java.util.ArrayList;

public class StartMenu {
    public static void main(String[] args) {
        Menu menu = new Menu(new ArrayList<>());
        Element elem1 = new Element("Задача 1", new ActionMenu("act 1"));
        Element elem2 = new Element("Задача 2", new ActionMenu("act 2"));
        menu.list.add(elem1);
        menu.list.add(elem2);
        menu.add("Задача 1", "Задача 1.1", new ActionMenu("act 1.1"));
        menu.add("Задача 1", "Задача 1.2", new ActionMenu("act 1.2"));
        menu.add("Задача 1", "Задача 1.3", new ActionMenu("act 1.3"));
        menu.add("Задача 1.1", "Задача 1.1.1", new ActionMenu("act 1.1.1"));
        menu.add("Задача 1.1", "Задача 1.1.2", new ActionMenu("act 1.1.2"));
        menu.add("Задача 2", "Задача 2.1", new ActionMenu("act 2.1"));
        menu.print();
        menu.select("Задача 2").act();
    }
}
