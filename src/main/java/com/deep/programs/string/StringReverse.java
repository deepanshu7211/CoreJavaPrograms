package com.deep.programs.string;

/**
 * Created by deepanshu.saxena on 16/06/16.
 */
public class StringReverse {
    public static void main(String[] args) {
//      reverse();
        System.out.println(reverse("java"));
    }

    public static void reverse() {
        String str = "java";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }

    public static String reverse(String str) {
        if (str.length() == 1)
            return str;
        else
            return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }
}
