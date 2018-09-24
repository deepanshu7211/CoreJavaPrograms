package com.deep.collectns;

/**
 * Created by deepanshu.saxena on 14/07/16.
 */
public class SumGeneric {

    public static <T extends Number> int sum(T t1, T t2) {
        return t1.intValue() + t2.intValue();
    }

    public static void main(String[] args) {
        System.out.println(sum(10l, 20l));
    }
}
