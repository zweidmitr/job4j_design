package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    /**
     * должен возвращать значение и удалять первый элемент из коллекции.
     *
     * @return удаленный элемент
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * помещает значение в коллекцию.
     *
     * @param value необходимое значение типа T
     */
    public void push(T value) {
        linked.addFirst(value);
    }
}
