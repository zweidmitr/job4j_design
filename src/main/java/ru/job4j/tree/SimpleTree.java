package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

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
        Optional<Node<E>> iParent = findBy(parent);
        Optional<Node<E>> iChild = findBy(child);
        if (iParent.isPresent() && iChild.isEmpty()) {
            iParent.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * проверяем есть ли в дереве элемент с таким значение...
     * условие - значение элемента = значению для проверки
     *
     * @param value
     * @return если находим элемент возвращаем его через Optional иначе Optional.empty()
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(element -> element.value.equals(value));
    }

    /**
     * проверяет дерево на бинарность, условие - у одного родителя от 0 до 2-х потомков
     *
     * @return если размер листа больше 2-х ... true / false
     */
    @Override
    public boolean isBinary() {
        return findByPredicate(element -> element.children.size() > 2).isEmpty();
    }

    /**
     * Этот класс использует алгоритм обхода в ширину.
     * В этом задании мы не будем касаться устройства работы этого алгоритма.
     * Вам нужно воспользоваться результатом его работы для реализации метода findBy and isBinary.
     *
     * @param condition - передаем предикат с необходимым условием
     * @return
     */
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                rsl = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }

        return rsl;
    }
}
