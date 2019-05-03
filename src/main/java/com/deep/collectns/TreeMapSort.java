package com.deep.collectns;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSort {
	public static void main(String[] args) {
		Map<Person,Integer> map = new HashMap<>();
		map.put(new Person("sang", "sang"), 3);
		map.put(new Person("deepanshu", "deepanshu"), 2);		
		map.put(new Person("deep", "deep"), 1);
		map.forEach((k,v) -> System.out.println(k +" key and value "+v));
		
		System.out.println("================ After SOrting the TreeMap ============= ");
		TreeMap<Person, Integer> sortedMap = new TreeMap<>(map);
		sortedMap.entrySet().stream().forEach(System.out::println);
		
		// Sort TreeMap by using Java 8
		System.out.println(" Sorting using by Java 8 ================ ");
		System.out.println("\n");
		System.out.println(" ================ Sorting by key =========== ");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("\n");
		System.out.println(" ================ Sorting by Value =========== ");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
	}
}

class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(o.getFirstName());
	}
	
	
}
