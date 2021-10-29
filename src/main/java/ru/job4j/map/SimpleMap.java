package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int modCount = 0;
    private int size = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = true;
        int keyIndex = indexFor(hash(key));
        if (table[keyIndex] != null) {
            result = false;
        }
        if (result) {
            expand();
            table[keyIndex] = new MapEntry<>(key, value);
            modCount++;
            size++;
        }
        return result;
    }

    /**
     * метод проверяет размер массива
     * и если загруженность массива превышает 0,75 то увеличиваем *2
     */
    private void expand() {
        if (size / capacity >= LOAD_FACTOR) {
            int newSize = table.length * 2;
            table = Arrays.copyOf(table, newSize);
            modCount++;
        }
    }

    /**
     * метод принимает хэшкод и сдвигает его на 16 пунктов вправо (16 раз делим на 2)
     * для того чтобы было меньше похожих хэшей
     *
     * @param key хэшкод элемента
     * @return возвращает число хэшкода
     */
    private int hash(K key) {
        return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >> 16);
    }

    /**
     * @param hash хеш-код полученный в результате работы hashCode()
     * @return результат «хеш-код» –> побитовое «И» –> (длина массива – 1).
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    @Override
    public V get(K key) {
        V result = null;
        int keyIndex = indexFor(hash(key));
        if (key != null && table[keyIndex] != null) {
            if (table[keyIndex].getKey().equals(key)) {
                result = table[keyIndex].getValue();
                modCount++;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int keyIndex = indexFor(hash(key));
        if (key != null && table[keyIndex] != null) {
            if (table[keyIndex].getKey().equals(key)) {
                table[keyIndex] = null;
                size--;
                result = true;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int expectedModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[cursor] != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hasNext() ? table[cursor++] : null;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
