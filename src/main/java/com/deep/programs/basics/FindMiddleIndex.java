/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.basics;

/**
 * @author deepanshu.saxena
 */
public class FindMiddleIndex {
    public static void main(String[] args) {
        int[] num = {2, 4, 4, 5, 4, 1};
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                    + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static int findMiddleIndex(int[] num) throws Exception {
        int start = 0;
        int end = num.length - 1;
        int suml = 0, sumr = 0;
        while (true) {
            if (suml > sumr) {
                sumr = sumr + num[end--];
            } else {
                suml = suml + num[start++];
            }
            if (start > end) {
                if (suml == sumr) {
                    break;
                } else {
                    throw new Exception("Please pass proper array to match the requirement");
                }

            }
        }
        return end;
    }
}
