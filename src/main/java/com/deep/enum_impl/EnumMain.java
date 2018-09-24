package com.deep.enum_impl;

/**
 * Created by deepanshu.saxena on 05/11/15.
 */
public class EnumMain {
    public static void main(String[] args) {
        System.out.println(Level.HIGH.getLevelCode());
        System.out.println(Level.HIGH);
        System.out.println(EnumObject.INSTANCE);
        EnumObject.INSTANCE.getTest().display();
    }
}
