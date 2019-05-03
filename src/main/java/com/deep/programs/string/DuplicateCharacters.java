package com.deep.programs.string;

import java.util.*;

/**
 * Created by deepanshu.saxena on 16/06/16.
 */
public class DuplicateCharacters {
    public static void main(String[] args) {
//    duplicate();
        countDuplicate();
    }

    public static void duplicate() {
        String str = "java";
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (characterSet.contains(str.charAt(i))) {
                System.out.println("Duplicate  :: " + str.charAt(i));
            } else {
                characterSet.add(str.charAt(i));
            }
        }
    }

    public static void countDuplicate() {
        String str = "java";
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!characterIntegerMap.containsKey(str.charAt(i))) {
                characterIntegerMap.put(str.charAt(i), 1);
            } else {
                characterIntegerMap.put(str.charAt(i), characterIntegerMap.get(str.charAt(i)) + 1);
            }
        }


        System.out.println(characterIntegerMap);

        Set<Map.Entry<Character, Integer>> entrySet = characterIntegerMap.entrySet();

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(entrySet);

        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Character, Integer> entry : entryList) {
            System.out.println("key ::  " + entry.getKey() + " value ::  " + entry.getValue());
        }
        
        // Sort by using Java 8
        System.out.println(" ===================== Sort using Java 8========= ");
        System.out.println("\n");
        
        characterIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        
        System.out.println("=========== Sort by Value ============= ");
        
        characterIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
