/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.basics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author deepanshu.saxena
 */
public class Basic {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        A a = new A();
        a.draw();
        Class cla = Class.forName("com.deep.java.basics.A");
        A b = (A) cla.newInstance();
        b.draw();
        My m = new My() {
        };
        m.myMethod();
        System.out.println("");
        int[][] arr = new int[2][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }


        int[] nums = {5, 2, 7, 2, 4, 7, 8, 2, 3};
        Set<Integer> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(" non repetiv :: " + entry.getKey());
            }
        }
    }

}


abstract class My {

    public My() {
    }

    public void myMethod() {
        System.out.print("Abstract");
    }
}

class A {
    public void draw() {
        System.out.println("in a");
    }
}


// For Static method overriding
//class A{
//    public static void draw()
//    {
//        System.out.println("in a");
//    }
//}
//
//class B extends A{
//    public static void draw()
//    {
//        System.out.println("in B");
//    }
//}