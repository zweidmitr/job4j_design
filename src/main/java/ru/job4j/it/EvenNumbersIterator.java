package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        int res = resultIndex();
        if (res != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = 0;
        int res = resultIndex();
        if (res != -1) {
            result = data[res];
            index = res + 1;
        }
        return result;
    }

    Integer resultIndex() {
        int result = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
