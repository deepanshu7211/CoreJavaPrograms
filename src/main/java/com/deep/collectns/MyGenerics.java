package com.deep.collectns;

/**
 * Created by deepanshu.saxena on 20/03/16.
 */
public class MyGenerics {
    public static void main(String[] args) {
        MyGenericType<String> myGenericType = new MyGenericType<>();
        myGenericType.set("hello");
        String str = myGenericType.get();
        System.out.println(str);
    }
}

class MyGenericType<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}