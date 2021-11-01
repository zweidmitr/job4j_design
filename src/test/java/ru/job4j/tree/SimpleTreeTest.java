package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenChildExistOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.add(2, 6));
    }

    @Test
    public void whenOneParentThreeChild() {
        Tree<Integer> tree = new SimpleTree<>(10);
        tree.add(10, 11);
        tree.add(10, 12);
        tree.add(10, 13);
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenOneParentOneChild() {
        Tree<Integer> tree = new SimpleTree<>(10);
        tree.add(10, 11);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenOneParentMoreChild() {
        Tree<Integer> tree = new SimpleTree<>(10);
        tree.add(10, 11);
        tree.add(10, 12);
        tree.add(11, 13);
        tree.add(13, 14);
        tree.add(14, 15);
        tree.add(14, 16);
        tree.add(14, 17);
        assertFalse(tree.isBinary());
    }

}