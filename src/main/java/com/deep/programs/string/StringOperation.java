package com.deep.programs.string;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by deepanshu.saxena on 16/06/16.
 */
public class StringOperation {
    public static void main(String[] args) {
        StringOperation stringOperation = new StringOperation();
//       stringOperation.findDuplicateChar("java");
//       stringOperation.firstNonRepetitive("Morning");
//       stringOperation.findanagram("aarmy", "maary");
//       stringOperation.reverse("java");
//         stringOperation.stringContainsNumber("abc1");
//          stringOperation.printDuplicateChar();
//       stringOperation.replacewith20("Java is Great");
//       stringOperation.permutation("", "ab");
         stringOperation.reverseSentence("Java is best programming language");
//       stringOperation.pallindrome("madama");
//        stringOperation.indexOfImp("abdabcb", "abc");
//       stringOperation.removeChar("java", 'v');
//       stringOperation.sortStringUsingLength("cataa,cat,cataaa,cata,cataaaa");
//       int result=stringOperation.powxy(2, 5);
//        System.out.println("result :: " + result);
//       stringOperation.longestPallindrome("forgeeksskeegfor");  //forgeeksskeegfor
//        stringOperation.checkRotateArray();
//        System.out.println(stringOperation.stringUniqueCharcter());

    }

    //Check If String has All Unique Characters
    private boolean stringUniqueCharcter() {
        String str = "Sumit_Jan";
        Boolean arr[] = new Boolean[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (arr[c] == true) {
                return false;
            } else {
                arr[c] = true;
            }
        }

        return true;
    }

    // Check if one string is Rotation of another string
    private void checkRotateArray() {
        String s1 = "sumitjain";
        String s2 = "tjainsumi";

        String newString = s1 + s1;
        if (newString.contains(s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private void findDuplicateChar(String str) {
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (char ch : arr) {
            if (set.contains(ch)) {
                System.out.println("duplicate character :: " + ch);
            } else {
                set.add(ch);
            }
        }
    }

    private void firstNonRepetitive(String str) {
        char[] arr = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("non repetetive char :: " + arr[i]);
                break;
            }
        }
    }

    private void findanagram(String source, String destination) {
        char[] charry = source.toCharArray();
        List<Character> original = new ArrayList<>();
        for (char ch : charry) {
            original.add(ch);
        }

        System.out.println(original);

        char[] arr2 = destination.toCharArray();
        for (char ch : arr2) {
            if (original.contains(ch)) {
                int index = original.indexOf(ch);
                original.remove(index);
            } else {
                original.add(ch);
            }
        }

        if (original.size() == 0) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not anagram");
        }

    }

    private void reverse(String str) {
        StringBuilder sb = new StringBuilder();
        char[] src = str.toCharArray();
        for (int i = src.length - 1; i >= 0; i--) {
            sb.append(src[i]);
        }
        System.out.println("reverse ::  " + sb.toString());
    }

    private void stringContainsNumber(String str) {
        Pattern pattern = Pattern.compile(".*[^0-9].*");
        System.out.println(" String contains number " + str + " " + !pattern.matcher(str).matches());
    }

    private void printDuplicateChar() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(" key :: " + entry.getKey() + " value :: " + entry.getValue());
            }
        }
    }

    private void replacewith20(String str) {
        char[] myString = new char[]{'T', 'H', 'I', 'S', ' ', 'I', 'S', ' ', 'T', 'E', 'S', 'T'};

        String output1 = new String(myString);
        System.out.println("output1 : " + output1);

        String s[] = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String s1 : s) {
            count++;
            sb.append(s1);
            if (count != s.length) {
                sb.append("%20");
            }
        }
        System.out.println(" replace string :: " + sb.toString());
    }

    private void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
//                System.out.println("word.charAt(i) ::   "+ word.charAt(i));
//                System.out.println("word.substring(0, i) :  " +word.substring(0, i));
//                System.out.println("word.substring(i + 1, word.length())   :: " + word.substring(i + 1, word.length()));

                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    private void reverseSentence(String word) {
        String[] str = word.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            count++;
            sb.append(str[i]);
            if (count != str.length) {
                sb.append(" ");
            }
        }
        System.out.println("reverse sentence :: " + sb.toString());
    }

    private void pallindrome(String str) {
        int i = 0;
        boolean flag = false;
        char[] arr = str.toCharArray();
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] == arr[j]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if (flag) {
            System.out.println("plallindrome");
        } else {
            System.out.println("not pallindrome");
        }
    }

    private void indexOfImp(String source, String target) {
        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        for (int i = 0; i < src.length; i++) {
            int j;
            for (j = 0; j < tar.length; j++) {
                if (src[i + j] != tar[j])
                    break;

            }

            if (j == tar.length)
                System.out.println("patter found :: " + i);
        }
    }

    private void removeChar(String str, char c) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != c)
                sb.append(ch);
        }
        System.out.println("remove char string :: " + sb.toString());
    }

    private void sortStringUsingLength(String source) {
        String[] str = source.split(",");
        Arrays.sort(str, new StringComparator());
        System.out.println(Arrays.asList(str));
    }

    private int powxy(int num, int pow) {
        if (pow == 1) {
            return num;
        } else {
            return num * powxy(num, pow - 1);
        }
    }

    private void longestPallindrome(String source) {

        char[] str = source.toCharArray();
        int maxLength = 1;  // The result (length of LPS)

        int start = 0;
        int len = str.length;

        int low, high;

        System.out.println("legth :: " + len);
        // One by one consider every character as center point of
        // even and length palindromes
        for (int i = 1; i < len; i++) {
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            low = i - 1;
            high = i;
            System.out.println("low ::: " + low + "  high :: " + high);
            while (low >= 0 && high < len && str[low] == str[high]) {

                System.out.println("high - low + 1 " + (high - low + 1) + " maxLength" + maxLength);
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
                System.out.println(" in while loop low ::: " + low + "  high :: " + high + " max length change :: " + maxLength + " start ::  " + start);
            }

            // Find the longest odd length palindrome with center
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
        }

        System.out.println("Longest palindrome substring is: " + "max lentgh " + maxLength + " " + (start + maxLength - 1));
        for (int i = start; i <= start + maxLength - 1; i++)
            System.out.print(str[i]);
        //printSubStr(str, start, start + maxLength - 1);
    }


}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
//        return Integer.compare(o2.length(), o1.length());

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}


