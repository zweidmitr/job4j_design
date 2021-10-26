package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        for (String s : strings) {
            System.out.println("текущий элемент: " + s);
        }
        strings.addAll(List.of("one", "four", "five"));
        System.out.println("-------------------");
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println("текущий элемент: " + iterator.next());
        }
        System.out.println("-------------------");
        strings.remove("two");
        System.out.println("Вывод после удаления");
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");
        strings.removeAll(List.of("two", "three"));
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");
        strings.retainAll(List.of("one"));
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");
        strings.add("two");
        strings.add("three");
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");
        strings.removeIf(elem -> elem.startsWith("t"));
        strings.forEach(elem -> System.out.println("текущий элемент: " + elem));
        System.out.println("-------------------");

    }
}
