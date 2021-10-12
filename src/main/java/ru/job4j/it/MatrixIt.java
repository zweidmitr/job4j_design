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
        loop:
        for (int i = row; i < data.length; i++) {
            for (int j = column; j < data[i].length; j++) {
                if (data[i].length != 0) {
                    row = i;
                    column = j;
                    result = true;
                    break loop;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column];
        while (column < data[row].length) {
            column++;
            break;
        }
        if (column == data[row].length) {
            column = 0;
            if (row < data.length) {
                row++;
            }
        }
        return result;
    }
}
