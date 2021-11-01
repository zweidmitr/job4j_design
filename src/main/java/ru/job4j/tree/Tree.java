package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Tree<E> {

    /**
     * НУжно проверить,что значения child еще нет в дереве, а parent есть
     *
     * @param parent находим узед по значению parent
     * @param child  добавляем дочерний узел со значением child
     * @return если child есть то нужно вернуть false
     */
    boolean add(E parent, E child);

    boolean isBinary();

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        /**
         * описывает узел дерева, содержит хранимое значение
         * и ссылки на дочерние узлы
         *
         * @param value
         */
        public Node(E value) {
            this.value = value;
        }
    }
}
