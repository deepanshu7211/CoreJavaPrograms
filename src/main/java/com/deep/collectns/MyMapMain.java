package com.deep.collectns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepanshu.saxena on 11/03/16.
 */
public class MyMapMain {
    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
    }
}


class MyMap<K, V> {

    private int size;
    private int DEFAULT_CAPACITY = 16;
    private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }

        if (insert) {
            ensurecap();
            values[size++] = new MyEntry<>(key, value);
        }
    }

    private void ensurecap() {
        if (size == values.length - 1) {
            int newlength = values.length * 2;
            values = Arrays.copyOf(values, newlength);
        }
    }

}

class MyEntry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;

        if (!key.equals(myEntry.key)) return false;
        return value.equals(myEntry.value);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}