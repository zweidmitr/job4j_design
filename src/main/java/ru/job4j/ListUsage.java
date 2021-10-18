package ru.job4j;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("add elem");
        System.out.println("===============================");
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        for (String s : rsl) {
            System.out.println("this is : " + s);
        }
        System.out.println("===============================");
        rsl.add(1, "four");
        rsl.forEach(elem -> System.out.println("this is: " + elem));
        System.out.println("===============================");
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(list);
        rsl.forEach(elem -> System.out.println("this is: " + elem));
        System.out.println("===============================");
        rsl.addAll(0, list);
        rsl.forEach(elem -> System.out.println("this is: " + elem));
        System.out.println("===============================");
        List<String> result = List.of("ein", "zwei", "drei");
        result.forEach(elem -> System.out.println("this is: " + elem));
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println();
        System.out.println();
        System.out.println("read elem");
        System.out.println("===============================");
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("this is index(" + i + "): " + rsl.get(i));
        }
        System.out.println("===============================");
        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("this is: " + iterator.next());
        }
        System.out.println("===============================");
        ListIterator<String> listIterator = rsl.listIterator(7);
        while (listIterator.hasNext()) {
            System.out.println("this is: " + listIterator.next());
        }
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println();
        System.out.println();
        System.out.println("correct elem");
        System.out.println("===============================");
        rsl.set(4, "two and second");
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        rsl.replaceAll(String::toUpperCase);
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println();
        System.out.println();
        System.out.println("remove elem");
        System.out.println("===============================");
        rsl.remove(0);
        rsl.remove(0);
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        rsl.remove("FOUR");
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        List<String> delList = new ArrayList<>();
        delList.add("ONE");
        delList.add("FIVE");
        rsl.removeAll(delList);
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        List<String> retainList = new ArrayList<>();
        retainList.add("TWO AND SECOND");
        retainList.add("FOUR");
        rsl.retainAll(retainList);
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        rsl.removeIf(elem -> elem.length() <= 4);
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        System.out.println("===============================");
        rsl.add(0, "ONE");
        rsl.add("THREE");
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        boolean b = rsl.contains("TWO AND SECOND");
        System.out.println("list has elem: " + b);
        System.out.println("===============================");
        int i = rsl.indexOf("TWO AND SECOND");
        System.out.println("index of elem: " + i);
        System.out.println("===============================");
        int insex = rsl.lastIndexOf("ONE");
        System.out.println("index of elem: " + insex);
        System.out.println("===============================");
        rsl.add("ONE");
        int index = rsl.lastIndexOf("ONE");
        System.out.println("index of elem: " + index);
        System.out.println("===============================");
        int size = rsl.size();
        System.out.println("size of list: " + size);
        System.out.println("===============================");
        List<String> subLIst = rsl.subList(1, 2);
        subLIst.forEach(elem -> System.out.println("subList: " + elem));
        System.out.println("===============================");
        rsl.sort(Comparator.reverseOrder());
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
        System.out.println("===============================");
        rsl.sort(Comparator.naturalOrder());
        rsl.forEach(elem -> System.out.println("this.is. " + elem));
    }
}
