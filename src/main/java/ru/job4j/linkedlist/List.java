package ru.job4j.linkedlist;

public interface List<E> extends Iterable<E> {
    /**
     * метод добавляет значение в конец
     * @param value значение определенного типа
     */
    void add(E value);

    /**
     * перебирает элементы до указанного индекса и возвращает значение
     * @param index индекс необходимого значения
     * @return возвращает элемент типа Е
     */
    E get(int index);
}
