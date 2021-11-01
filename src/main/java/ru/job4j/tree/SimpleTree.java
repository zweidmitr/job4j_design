package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * НУжно проверить,что значения child еще нет в дереве, а parent есть
     * ждя этого создаем две переменных
     * в одну(iParent) записываем результат вызова метода findBy(parent),
     * в другую (iChild) - результат вызова метода findBy(child),
     * затем проверяем, что iParent значение существует,
     * а iChild - не существует (пустое),
     * и добавляем в список детей парента значение чайлд
     *
     * @param parent находим узел по значению parent
     * @param child  добавляем дочерний узел со значением child
     * @return если child есть то нужно вернуть false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> iParent = findBy(parent).orElse(null);
        Node<E> iChild = findBy(child).orElse(null);
        if (iParent != null && iChild == null) {
            iParent.children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Этот класс использует алгоритм обхода в ширину.
     * В этом задании мы не будем касаться устройства работы этого алгоритма.
     * Вам нужно воспользоваться результатом его работы для реализации метода add.
     *
     * @param value
     * @return
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.value.equals(value)) {
                rsl = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return rsl;
    }
}
