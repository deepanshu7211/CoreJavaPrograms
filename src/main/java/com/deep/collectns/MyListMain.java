package com.deep.collectns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deepanshu.saxena on 11/03/16.
 */

public class MyListMain {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);

        System.out.println(myList.get(2));
        List<String> stringList = new ArrayList<>(100);
        System.out.println(stringList.size());
    }
}

class MyList<E> {
    private int size = 0;
    private int default_capacity = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[default_capacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            increasesize();
        }
        elements[size++] = e;
    }
    
    public void remove(int index)
    {
        Object temp = elements[index];
        for(int i = index; i <size;i++)
        {
            elements[i]=elements[i+1];
        }

        elements[--size] = null;
    }

    private void increasesize() {
        int newsize = elements.length * 2;
        elements = Arrays.copyOf(elements, newsize);
    }

    public E get(int i) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        } else {
            return (E) elements[i];
        }

    }

    public int size() {
        return size;
    }


}
