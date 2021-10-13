package ru.job4j.it;

import java.util.*;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (cursor.hasNext() && cursor == null) {
            cursor = data.next();
        }
        while (cursor != null && data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }

        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
        String string1 = "Амиго";
        String string2 = string1;
        String string3 = new String(string1);
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
        System.out.println(string2 == string3);
    }
}
