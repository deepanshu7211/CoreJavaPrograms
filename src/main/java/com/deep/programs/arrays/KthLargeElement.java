/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.arrays;

import java.util.Arrays;

/**
 * @author deepanshu.saxena
 */
public class KthLargeElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        LargeElement largeElement = new LargeElement();
        largeElement.getKLargeElement(3, arr);
        System.out.println(" k larg element are :: " + Arrays.toString(largeElement.getArray()));
        System.out.println(arr[3]);
    }
}

class LargeElement {
    private int array[];
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void getKLargeElement(int k, int arr[]) {
        this.array = arr;
        length = arr.length;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
