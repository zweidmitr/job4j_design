package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * метод добавляет новое значение в список,
     * создает ноду, передвигает хвост
     * @param value значение которое добавляем
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * метод удаляет первое значение
     * сперва проверяем есть ли вообще head, если есть следующая нода(2),
     * то делаем head его же ссылко на (2) элемент
     *
     * @return возвращаем значение удаленного элемента
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> result = head;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        return result.value;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}
