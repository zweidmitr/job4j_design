package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public int lastRet;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * добавляем новые элементы в лист
     * увеличиваем размер массива?
     */
    @Override
    public void add(T value) {
        if (size == container.length) {
            T[] newContainer = (T[]) new Object[container.length * 2];
            T temp;
            for (int i = 0; i < container.length - 1; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
        }
        container[size] = value;
        size++;
        modCount++;
    }

    /**
     * непонятно зачем return ... мы же должны просто поменять значение на новое
     */
    @Override
    public T set(int index, T newValue) {
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;

    }

    /**
     * удаляем элемент по индексу, образец из примера
     * уменьшаем размер массива
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = container;
        T oldValue = (T) es[index];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[container.length - 1] = null;
        size--;
        return oldValue;
    }

    /**
     * получаем элемент массива по индексу*/
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    /**
     * возвращаем размер массива
     * увеличиваем при добавлении элемента
     * уменьшаем при удалении*/
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public T next() {
                int i = cursor;
                if (i >= size) {
                    throw new NoSuchElementException();
                }
                cursor = i + 1;
                lastRet = i;
                return (T) container[i];
            }

        };
    }
}