package ru.job4j.linkedlist;

import ru.job4j.collection.ForwardLinked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private int modcount;


    /**
     * добавляем элемент в linkedList
     * копируем последний элемент,
     * создаем новую ноду, делая ее последней
     * если лист пустой, добавляем эту ноду в head
     * если значения уже есть, добавляем в последней копии (prev) ссылку на новый элемент
     *
     * @param value значение определенного типа
     */
    @Override
    public void add(T value) {
        Node<T> prev = tail;
        tail = new Node<>(value, null);
        if (head == null) {
            head = tail;
        } else {
            prev.next = tail;
        }
        size++;
        modcount++;
    }

    /**
     * получаем элемент по индексу, обойдя всю цепочку с head
     * у предпоследнего элемента по ссылке полчаем наш элемент
     *
     * @param index индекс необходимого значения
     * @return
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modcount;
            private int cursor = 0;
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> itrNode = node;
                node = node.getNext();
                cursor++;
                return itrNode.getValue();
            }
        };
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}
