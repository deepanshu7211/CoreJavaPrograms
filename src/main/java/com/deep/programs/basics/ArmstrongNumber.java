/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.programs.basics;

/**
 * @author deepanshu.saxena
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        System.out.println("Is 371 Armstrong number? " + armstrongNumber.isArmsStrongNumber(371));
        System.out.println("Is 523 Armstrong number? " + armstrongNumber.isArmsStrongNumber(523));
        System.out.println("Is 153 Armstrong number? " + armstrongNumber.isArmsStrongNumber(153));

        System.out.println(isPrime(3));

    }

    public static boolean isArmsStrongNumber(int num) {
        int div = 0, sum = 0;
        int tmp = num;
        int noOfDigits = String.valueOf(num).length();
        while (tmp > 0) {
            div = tmp % 10;
            int temp = 1;
            for (int i = 0; i < noOfDigits; i++) {
                temp *= div;
            }
            sum += temp;
            tmp = tmp / 10;
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
//        System.out.println(count);

        if (count == 2)
            return true;
        else
            return false;
    }
}
