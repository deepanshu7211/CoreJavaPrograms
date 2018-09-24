/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.arrays;

/**
 * @author deepanshu.saxena
 */
public class ClosestPairTwoArrays {
    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x = 38;
        FindPair findPair = new FindPair();
        findPair.findPairNum(ar1, ar2, x);
        System.out.println("pair ares :: " + ar1[findPair.getL_pair()] + " -- " + ar2[findPair.getR_pair()]);
    }
}

class FindPair {
    private int arr1[], arr2[];
    private int length, length1;
    private int l_pair, r_pair;

    public int getL_pair() {
        return l_pair;
    }

    public int getR_pair() {
        return r_pair;
    }


    public void findPairNum(int ar1[], int ar2[], int sum) {
        this.arr1 = ar1;
        this.arr2 = ar2;
        length = ar1.length;
        length1 = ar2.length;
        int l = 0, r = length1 - 1, diff = Integer.MAX_VALUE;
        System.out.println("diff " + diff);
        //int l_pair=0,r_pair=0;

        while (l < length && r >= 0) {
            if (Math.abs(arr1[l] + arr2[r] - sum) < diff) {
                diff = Math.abs(arr1[l] + arr2[r] - sum);
                l_pair = l;
                r_pair = r;
            }


            if ((arr1[l] + arr2[r]) > sum)
                r--;
            else
                l++;
        }

    }
}
