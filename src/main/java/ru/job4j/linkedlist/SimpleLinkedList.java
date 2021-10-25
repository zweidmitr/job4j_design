package ru.job4j.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;
    private int modcount;

    /**
     * создается LinkedList
     */
    public SimpleLinkedList() {
        this.lstNode = new Node<>(null, fstNode, null);
        this.fstNode = new Node<>(null, null, lstNode);

    }

    /**
     * добавляем элемент value в LedList
     * увеличиваем размер
     * @param value значение определенного типа
     */
    @Override
    public void add(E value) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(value);
        lstNode = new Node<>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
        modcount++;
    }

    /**
     * получаем элемент по индексу, обойдя всю цепочку с самого начала
     * @param index индекс необходимого значения
     * @return
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElem(target);
        }
        return target.getCurrentElement();
    }

    /**
     *
     * @param target
     * @return
     */
    private Node<E> getNextElem(Node<E> target) {
        return target.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modcount;
            private int cursor = 0;
            private Node<E> node = fstNode;

            @Override
            public boolean hasNext() {

                return cursor < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> itrNode = node;
                node = node.getNextElement();
                cursor++;
                return itrNode.getCurrentElement();
//                return itrNode.getNextElement();
            }
        };
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

        public E getCurrentElement() {
            return  currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
}
