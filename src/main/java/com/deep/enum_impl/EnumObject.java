package com.deep.enum_impl;

/**
 * Created by deepanshu.saxena on 05/11/15.
 */

public enum EnumObject {

    INSTANCE;


    private Test test;

    public Test getTest() {
        return this.test = new Test();
    }
}
