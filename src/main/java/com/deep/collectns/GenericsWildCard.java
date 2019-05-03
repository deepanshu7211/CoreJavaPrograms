package com.deep.collectns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsWildCard {
	public static void main(String[] args) {
		// How HashMap behaves with Generics
		Map<String, EmpGenerics> empIntegerHashMap = new HashMap<String, EmpGenerics>();
		empIntegerHashMap.put("emp", new EmpGenerics(1, "deep"));
		empIntegerHashMap.put("manager", new Manager());

		// Display Map using Java 8
		System.out.println(" printing using Lambda expression ");
		empIntegerHashMap.forEach((k,v) -> System.out.println(" key " + k + " value " + v));
		System.out.println(" printing Map using method reference");
		empIntegerHashMap.entrySet().stream().forEach(System.out::println);

		//How List will behave with Generics
		List<EmpGenerics> empGenericsList = new ArrayList<>();
		empGenericsList.add(new EmpGenerics(2,"deepanshu"));
		empGenericsList.add(new Manager());
		empGenericsList.add(new SeniorManager());
		System.out.println(" printing list using method reference");
		empGenericsList.stream().forEach(System.out::println);

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
		basicList.add(new Dog());
		basicList.forEach( v -> System.out.println(" list item value " + v));
		addanimals.add(new Cat());
//		animals.add(new Cat());
		traverse(basicList);
		
		//Now create a List of Cat
		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat());
		cats.add(new Cat());
		traverseAnimalAndCats(cats); // It will show the compilation error as List<Animal> != List<Cat>
		addAnimal(basicList);
//		addAnimal(cats); // It will show the compilation error as List<Animal> != List<Cat>
	}

	private static void addtoList(List<Object> objectList) {

	}
	
	
	private static void addAnimal(List<Animal> animals) {
		animals.add(new Cat());
	}
	
	// TO support List<Cat> we need to do ? extends Animal
	private static void traverse(List<Animal> animals) {
		for(Animal animal: animals) {
			animal.sound();
		}
	}
	
	private static void traverseAnimalAndCats(List<? extends Animal> animals) {
		for(Animal animal: animals) {
			animal.sound();
		}
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

class SeniorManager extends EmpGenerics{
	
}

class Animal {
	public void sound() {
		
	}
}

class Cat extends Animal {
	public void sound() {
		System.out.println("meow");
	}
}

class Dog extends Animal {
	public void sound() {
		System.out.println("bow");
	}
}