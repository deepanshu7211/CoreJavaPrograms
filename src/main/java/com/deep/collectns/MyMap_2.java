package com.deep.collectns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 14/03/16.
 */

public class MyMap_2 {
    public static void main(String[] args) {
        MyCustomMap myCustomMap = new MyCustomMap();

        for (int i = 1; i <= 10; i++) {
            myCustomMap.put(String.valueOf(i), i);
        }

        System.out.println("map size :: " + myCustomMap.size());
        myCustomMap.remove("3");

        Set<Object> keyset = myCustomMap.keySet();
        for (Object obj : keyset) {
            System.out.println("key :: " + obj + " value :: " + myCustomMap.get(obj));
        }
    }
}


class MyCustomMap {
    private int size;
    private int DEFAULT_CAPACITY = 16;
    private Entry[] entries = new Entry[DEFAULT_CAPACITY];

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    public void put(Object key, Object value) {
        boolean insert = true;

        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i].setValue(value);
                insert = false;
            }
        }

        if (insert) {
            ensurecap();
            entries[size++] = new Entry(key, value);
        }
    }

    public void remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i] = null;
//                System.out.println("size :: " + size);
                size--;
                condensearray(i);
            }
        }
    }

    public Set<Object> keySet() {
        Set<Object> keyset = new HashSet<>();
        for (int i = 0; i < size; i++) {
            keyset.add(entries[i].getKey());
        }

        return keyset;
    }

    private void condensearray(int start) {
//        System.out.println("condensearray size :: " + size + "  start :: " + start);
        for (int i = start; i < size; i++) {
            entries[i] = entries[i + 1];
        }

    }

    public int size() {
        return size;
    }

    private void ensurecap() {
        if (size == entries.length - 1) {
            int newsize = entries.length * 2;
            entries = Arrays.copyOf(entries, newsize);
        }
    }
}

class Entry {
    private Object key;
    private Object value;


    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;
        if (!key.equals(entry.getKey())) return false;

        return value.equals(entry.getValue());

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}