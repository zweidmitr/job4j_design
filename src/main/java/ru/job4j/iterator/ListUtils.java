package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    /**
     * вставляет значение перед индексом
     *
     * @param list  список обрабатываемых значений / коллекция
     * @param index индекс перед которым необходимо поставить элемент
     * @param value значение элемента
     * @param <T>   тип элемента
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index);
        i.add(value);
    }

    /**
     * вставляет значение ппосле заданного индекса
     *
     * @param list  список обрабатываемых значений / коллекция
     * @param index индекс после которого необходимо поставить элемент
     * @param value значение элемента
     * @param <T>   типа элемента
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index + 1);
        i.add(value);

    }

    /**
     * удаляет все элементы, которые удовлетворяют предикату
     *
     * @param list   список обрабатываемых значений / коллекция
     * @param filter принимаем любое условие, например "item -> item >= 4"
     * @param <T>    тип элемента
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T elem = i.next();
            if (filter.test(elem)) {
                i.remove();
            }
        }
    }

    /**
     * заменяет все элементы, которые удовлетворяют предикату
     *
     * @param list   список обрабатываемых значений / коллекция
     * @param filter принимаем условие, например "item -> item < 4"
     * @param value  меняем значение элементов удовлетворяющих условия на заданное значение
     * @param <T>    тип элемента
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T elem = i.next();
            if (filter.test(elem)) {
                i.set(value);
            }
        }

    }

    /**
     * удаляет из списка те элементы, которые есть в elements.
     *
     * @param list список обрабатываемых значений / коллекция
     * @param elements коллекция элементов по которой проходим и элементы которой удаляем в первоначальном лисет
     * @param <T> тип элемента
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = elements.listIterator();
        while (i.hasNext()) {
            list.remove(i.next());
        }

    }
}
