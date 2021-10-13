package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.forEach(elem -> System.out.println("Текущий элемент: " + elem));
    }
}
