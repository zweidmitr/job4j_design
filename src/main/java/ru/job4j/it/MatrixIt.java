package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int[] number : data) {
            if (number.length != 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[row].length == 0) {
            row++;
        }
        int result = data[row][column];
        int res = result;
        if (column < data[row].length) {
            column++;
        }
        if (column == data[row].length) {
            column = 0;
            if (row < data.length) {
                row++;
            }
        }

        return res;
    }
}
