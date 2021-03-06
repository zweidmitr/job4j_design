package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public SimpleArrayList() {
        this.container = (T[]) new Object[10];
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
    private void increaseLength() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    /**
     * @param index индекс заменяемого значения
     * @param newValue новое значение для замены
     * @return метод set() в стандартных реализациях возвращает значение, которое было ранее в коллекции
     * и которое замнили новым, то вот его и возвращают, чтоб не потерять.
     * Можно и не использовать.
     */
    @Override
    public T set(int index, T newValue) {
        T oldValue = get(index);
        container[index] = newValue;
        return oldValue;

    }

    /**
     * @param index индекс необходимого элемента
     * @return в соответствии с сигнатурой метода возвращаем значение,
     * исходя из логики и практики возвращаемое значение то, которое удаляем из коллекции.
     */
    @Override
    public T remove(int index) {
        T oldValue = get(index);
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
        Objects.checkIndex(index, size);
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
                return container[cursor++];
            }

        };
    }
}