package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size = 0;

    /**
     * для проверки стека на пустоту
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * должен возвращать значение и удалять первый элемент из коллекции.
     *
     * @return удаленный элемент
     */
    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    /**
     * помещает значение в коллекцию на первое место.
     *
     * @param value необходимое значение типа T
     */
    public void push(T value) {
        size++;
        linked.addFirst(value);
    }
}
