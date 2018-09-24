package com.deep.enum_impl;

/**
 * Created by deepanshu.saxena on 19/11/15.
 */
public class Node {
    int key;
    String name;

    Node left, right;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", key=" + key +
                '}';
    }
}
