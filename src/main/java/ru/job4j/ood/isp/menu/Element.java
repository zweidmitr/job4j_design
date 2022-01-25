package ru.job4j.ood.isp.menu;

import java.util.ArrayList;

public class Element implements Menu {
    private Element prev;
    private Element next;
    private ArrayList<Element> allElements = new ArrayList<>();
    private String name;

    @Override
    public String getName() {
        return this.name;
    }
}
