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
        ListIterator<T> iterator = list.listIterator(index);
        iterator.add(value);
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
        ListIterator<T> iterator = list.listIterator(index + 1);
        iterator.add(value);

    }

    /**
     * удаляет все элементы, которые удовлетворяют предикату
     *
     * @param list   список обрабатываемых значений / коллекция
     * @param filter принимаем любое условие, например "item -> item >= 4"
     * @param <T>    тип элемента
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (filter.test(elem)) {
                iterator.remove();
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
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (filter.test(elem)) {
                iterator.set(value);
            }
        }

    }

    /**
     * удаляет из списка те элементы, которые есть в elements.
     * при проходе листИтератора, проверяем есть ли во втором списке нужные нам элементы
     * @param list     список обрабатываемых значений / коллекция
     * @param elements коллекция элементов по которой проходим и элементы которой удаляем в первоначальном лисет
     * @param <T>      тип элемента
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (elements.contains(iterator.next())) {
                iterator.remove();
            }
        }

    }
}
