package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>();
    private int size;

    /**
     * метод добавляет новые элементы, если они проходят проверку на уникальность
     * @param value значение нового элемента
     * @return true - добавлен новый элемент; false - элемент не прошел проверки
     */
    @Override
    public boolean add(T value) {
        boolean result = contains(value);
        if (!result) {
            set.add(value);
        }
        return result;
    }

    /**
     * метод перебирает всю коллекцию и сравниевает элемент с каждым значением
     * используем for()
     * @param value значение для проверки
     * @return true - элемент уже есть в коллекции; false - элемент уникален
     */
    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T temp : set) {
            if (Objects.equals(temp, value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}
