package com.deep.programs.arrays;

import java.util.Arrays;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class ArrayOperations {
    public static void main(String[] args) {
        oddoccurence();
//        missingNumber();
//        reverseArray();
//        rotateArray();
//          kthlargest();
//         maxNumber();
//        largest_sum_contigous_subarray();
    }

    private static void maxNumber() {
        int arr[] = {1, 2, 3, 5, 6};
        int max1 = 0, max2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;
                max1 = arr[i];

//                System.out.println(" " + max1 + " " + max2);
            } else {
                if (max2 < arr[i]) {
                    max2 = arr[i];
                }
            }
        }
        System.out.println(" max 1   " + max1);
        System.out.println(" max 2   " + max2);
    }

    private static void oddoccurence() {
        int arr[] = {1, 2, 2, 3, 3, 4, 1, 1, 1};
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        System.out.println(res);
    }

    private static void missingNumber() {
        int arr[] = {1, 2, 3, 5, 6};
        int sum = 0;
        sum = 6 * (6 + 1) / 2;
        System.out.println("sum is :: " + sum);
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }
        System.out.println(sum);
    }

    private static void reverseArray() {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

    }

    private static void rotateArray() {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int rot = 2;
        int temp[] = new int[rot];
//        System.out.println(arr.length);

        for (int i = 0; i < rot; i++) {
//            temp[i] = arr[i];
            temp[temp.length-1-i]=arr[i];
        }

        for (int i = 0; i < rot; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
        }
        int j = 0;

        while (j < rot) {

            arr[arr.length - 1 - j] = temp[j];
            j++;
        }

        // print array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void kthlargest() {
        int arr[] = {2, 3, 1, 4, 6, 5};
        Arrays.sort(arr);
        int k = 2;
        System.out.println("kth highest  " + arr[arr.length - 1 - k]);
    }

    // For Reference Check Geeks For all negative numbers in an arrays use case
    // https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/    
    private static void largest_sum_contigous_subarray()
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max =Integer.MIN_VALUE,max_end=0;
        for(int i=0;i<a.length;i++)
        {
            max_end = max_end + a[i];
            if(max_end<0)
                max_end=0;
            if(max<max_end)
                max = max_end;
        }
        System.out.println("max sub array :: " + max);
    }
}
