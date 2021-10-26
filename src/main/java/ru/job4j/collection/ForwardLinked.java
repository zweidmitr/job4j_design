package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * метод добавляет новое значение в список,
     * создает ноду, передвигает tail
     * добавляет ссылку на эту ноду в tail
     *
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

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    /**
     * метод удаляет первое значение
     * сперва проверяем есть ли вообще head, если есть следующая нода(2),
     * то делаем head его же ссылко на (2) элемент
     * в удаляемой node надо обнулить ссылку next, которая в ней содержится
     *
     * @return возвращаем значение удаленного элемента
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> result = head;
        head = (head.next == null) ? null : head.next;
        result.next = null;
        return result.value;
    }

    /**
     * метод разворачивает односвязный список
     * в первую очередь проверка на количество элементов в списке
     * создаем переменную со ссылкой на второй (2) элемент (current)
     * обнуляем ссылку самого первого (1) элемента head
     * проходим циклом от второго элемента до конца
     * делаем временную переменную на третий элемент (3)
     * у current делаем ссылку на head (2) -> (1)
     * сдвигаем весь цикл присваивая head ->(2), a current -> (3)
     * повторить
     * @return false || true
     */
    public boolean revert() {
        if (head != null && head.next != null) {
            tail = head;
            Node<T> current = head.next;
            head.next = null;
            while (current != null) {
                Node<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }
            return true;
        }
        return false;
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
