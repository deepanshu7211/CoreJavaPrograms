package com.deep.programs.string;

/**
 * Created by deepanshu.saxena on 16/06/16.
 */
public class StringOther {
    public static void main(String[] args) {
        //vowelscount();


    }

    public static void vowelscount() {
        String str = "vowels";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:

            }
        }

        System.out.println("No. of vowels :: " + count);
    }


}
