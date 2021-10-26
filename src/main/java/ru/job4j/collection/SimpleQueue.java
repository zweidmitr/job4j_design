package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack();
    private final SimpleStack<T> out = new SimpleStack();

    /**
     * должен возвращать первое значение и удалять его из коллекции.
     * пока в первом стеке есть значения,  удаляем из него, добавляя во второй
     * (3)(2)(1) -> (3) -> (2)(3) -> (1)(2)(3)
     * далее из второго удаляем первое значение (1)
     *
     * @return первое значени из второго стека
     */
    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * помещает значение в начало списка
     * т.к. каждое новое значение будет с индексом 0
     * (1) -> (2)(1) ->(3)(2)(1)
     *
     * @param value
     */
    public void push(T value) {
        in.push(value);
    }
}
