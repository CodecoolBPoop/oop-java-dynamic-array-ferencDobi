package com.codecool.dynamicArrayDojo;

import java.util.stream.IntStream;

public class DynamicIntArray {
    private int[] values;

    private int size() {
        return values.length;
    }

    DynamicIntArray() {
        this.values = new int[0];
    }

    DynamicIntArray(int length) {
        this.values = IntStream.range(0, length - 1).toArray();
    }

    public void add(int value) {
        int[] temp = new int[size() + 1];
        System.arraycopy(values, 0, temp, 0, size());
        temp[temp.length - 1] = value;
        values = temp;
    }

    public void remove(int index) {
        int[] temp = new int[size() - 1];
        System.arraycopy(values, 0, temp, 0, index);
        System.arraycopy(values, index + 1, temp, index, size() - index - 1);
        values = temp;
    }

    public void insert(int index, int value) {
        if (index > size()) index = size();
        int[] temp = new int[size() + 1];
        System.arraycopy(values, 0, temp, 0, index);
        temp[index] = value;
        System.arraycopy(values, index, temp, index + 1, size() - index);
        values = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int value : values) {
            sb.append(" ");
            sb.append(value);
        }
        return sb.toString();
    }
}
