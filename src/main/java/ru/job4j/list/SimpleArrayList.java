package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * добавляем в контейнер новое значение
     * проверяем надо ли увеличивать размер
     * @param value добавляемое значение
     */
    @Override
    public void add(T value) {
        if (size == container.length) {
            increaseLength();
        }
        container[size] = value;
        size++;
        modCount++;
    }

    /**
     * метод увеличивает размер массива в два раза
     */
    void increaseLength() {
        T[] newContainer = (T[]) new Object[container.length * 2];
        T temp;
        for (int i = 0; i < container.length - 1; i++) {
            newContainer[i] = container[i];
        }
        container = newContainer;
    }

    /**
     * @param index индекс заменяемого значения
     * @param newValue новое значение для замены
     * @return непонятно зачем return ... мы же должны просто поменять значение на новое
     */
    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;

    }

    /**
     * @param index индекс необходимого элемента
     * @return возвращаем старое значение (внезапно)
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
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
     * @param index индекс необходимого элемента
     * @return возвращает элемент массива по индексу
     * Objects.checkIndex(index, array.length);
     * == if (index < 0 || index >= array.length) {throw new IndexOutOfBoundsException();}
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    /**
     *
     * @return возвращает количество добавленных элементов != container.length
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * количество изменений
             * этот показатель всегда растет
             */
            private int expectedModCount = modCount;
            /**
             * указатель итератора
             */
            private int cursor = 0;

            /**
             * проверка след элемента в размере
             * @return true/false
             * ConcurrentModificationException. Относится ко второму показателю - числу модификаций.
             * Чтобы кинуть это исключение заводят отдельную переменную в итераторе expectedModCount = modCount
             * и проверяют условие if (expectedModCount != modCount).
             * Если условие выполнено, значит на момент итерирования была изменена коллекция, поэтому вылетает исключение.
             * Это называется fail-fast поведение
             */
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            /**
             *
             * @return двигает указатель на ++ т возвращает элемент контейнера
             *
             * ConcurrentModificationException. Относится ко второму показателю - числу модификаций.
             * Чтобы кинуть это исключение заводят отдельную переменную в итераторе expectedModCount = modCount
             * и проверяют условие if (expectedModCount != modCount).
             * Если условие выполнено, значит на момент итерирования была изменена коллекция, поэтому вылетает исключение.
             * Это называется fail-fast поведение
             *
             * NoSuchElementException. Относится к первому показателю - количеству элементов.
             * Если итератор "уперся", т.е. нет больше элементов, а клиент вызвал этот метод,
             * то этим исключение мы ему подчеркиваем, что элементов больше нет.

             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[cursor++];
            }

        };
    }
}