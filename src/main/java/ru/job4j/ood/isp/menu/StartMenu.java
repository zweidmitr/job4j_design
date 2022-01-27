package ru.job4j.ood.isp.menu;

public class StartMenu {
    public static void main(String[] args) {
        Menu menu = new Menu("Задача", new ActionMenu("act 0"));
        menu.add("Задача", "Задача 1", new ActionMenu("act 1.1"));
        menu.add("Задача 1", "Задача 1.2", new ActionMenu("act 1.2"));
        menu.add("Задача 1", "Задача 1.3", new ActionMenu("act 1.3"));
        menu.add("Задача", "Задача 2", new ActionMenu("act 2"));
        menu.add("Задача 2", "Задача 2.1", new ActionMenu("act 2.1"));
        String result = menu.print();
        System.out.println(result);
        menu.select("Задача").act();
    }
}
