/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.basics;

import java.util.HashSet;

/**
 * @author deepanshu.saxena
 */
public class HashAndEqual {
    public static void main(String[] args) {
        HashSet<Dog> dogSet = new HashSet<Dog>();
        dogSet.add(new Dog("white"));
//		dogSet.add(new Dog("white"));

        System.out.println("We have " + dogSet.size() + " white dogs!");
        Dog d1 = new Dog("white");
        Dog d2 = new Dog("white");
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));

        if (dogSet.contains(new Dog("white"))) {
            System.out.println("We have a white dog!");
        } else {
            System.out.println("No white dog!");
        }
    }
}

class Dog {
    String color;

    public Dog(String s) {
        color = s;
    }

    //overridden method, has to be exactly the same like the following
    public boolean equals(Object obj) {
        System.out.println("equals method called... ");
        if(null == obj)
        	return false;
        if (!(obj instanceof Dog))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Dog) obj).color);
    }

    public int hashCode() {
        System.out.println(" hashcode called.... ");
        return color.length();//for simplicity reason
    }
}