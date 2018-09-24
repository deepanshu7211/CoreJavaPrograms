package com.deep.enum_impl;

/**
 * Created by deepanshu.saxena on 05/11/15.
 */
public enum Level {
    HIGH(1),
    LOW(2),
    MEDIUM(3);

    private int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }
}
