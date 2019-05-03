/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.arrays;

/**
 * @author deepanshu.saxena
 */
public class ArraySumX {
    private static int arr[] = {1, 4, 45, 6, 10, -8};
    private static int sum = 16;

    public static void main(String[] args) {

        printarray(arr);
        sortarray(arr);
        printarray(arr);
        findsum(arr,sum);
//        findsumnormal(arr,sum);
    }

    private static void printarray(int[] arr) {
        //System.out.println("lenght :: " + arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println("i :: " + arr[i]);
    }

    private static void sortarray(int[] arr) {
        // Using Bubble Sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    private static void findsum(int[] arr, int sum) {
        int l = 0, r = 0;
        r = arr.length - 1;
        while (l <= r) {
            if (arr[l] + arr[r] == sum) {
                System.out.println("pair element are " + arr[l] + " " + arr[r]);
                break;
            }
            else if (arr[l] + arr[r] < sum)
                l++;
            else
                r--;

        }
    }

    private static void findsumnormal(int arr[], int sum) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.printf("i and j " + arr[i] + " " + arr[j]);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
    }

}
