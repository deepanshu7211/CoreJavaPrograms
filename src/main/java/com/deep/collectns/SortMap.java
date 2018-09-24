package com.deep.collectns;

import java.util.*;

/**
 * Created by deepanshu.saxena on 14/03/16.
 */
public class SortMap {
    public static void main(String[] args) {
        SortMapOnKeyStringExample sortMapOnKeyStringExample = new SortMapOnKeyStringExample();
//        sortMapOnKeyStringExample.buildMap();

        SortMapOnValueIntegerExample sortMapOnValueIntegerExample = new SortMapOnValueIntegerExample();
        sortMapOnValueIntegerExample.buildMap();
    }
}

class SortMapOnValueIntegerExample {
    public void buildMap() {
        Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......");
        Map<String, Integer> sortedMap = sortByComparator(unsortMap);

        printMap(sortedMap);
    }

    private Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
        //Convert Map to list
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        //Sort the list

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //Convert List to Map
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private void printMap(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}

class SortMapOnKeyStringExample {
    public void buildMap() {
        Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        System.out.println("Unsort Map......");

        printMap(unsortMap);
        System.out.println(" \n Sorted Map ");
        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
        printMap(treeMap);
    }

    private void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}