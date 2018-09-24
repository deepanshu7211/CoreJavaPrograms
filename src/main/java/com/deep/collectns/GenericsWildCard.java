package com.deep.collectns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsWildCard {
	public static void main(String[] args) {
		Map<String, EmpGenerics> empIntegerHashMap = new HashMap<String, EmpGenerics>();
		empIntegerHashMap.put("emp", new EmpGenerics(1, "deep"));
		empIntegerHashMap.put("manager", new Manager());

		List<Object> list = new ArrayList<Object>();
		// List<? extends Object> objectsList = new ArrayList<String>();
		// List<? super Object> addList = new ArrayList<Object>();
		list.add(new String());
		List<String> stringList = new ArrayList<String>();
		addtoList(list);

		List<? extends Animal> animals = new ArrayList<Animal>();
		List<? super Animal> addanimals = new ArrayList<Animal>();
		List<Animal> basicList = new ArrayList<Animal>();
		basicList.add(new Cat());
		addanimals.add(new Cat());
//		animals.add(new Cat());
	}

	private static void addtoList(List<Object> objectList) {

	}
}

class EmpGenerics {
	private int id;
	private String name;

	public EmpGenerics() {
	}

	public EmpGenerics(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}

class Manager extends EmpGenerics {

}

class Animal {

}

class Cat extends Animal {

}

class Dog extends Animal {

}