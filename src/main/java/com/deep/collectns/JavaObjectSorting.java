package com.deep.collectns;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by deepanshu.saxena on 07/04/16.
 */

public class JavaObjectSorting {
	public static void main(String[] args) {
		// sorting custom object array

		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		Arrays.sort(empArr);
		System.out.println(Arrays.toString(empArr));
		Arrays.sort(empArr, Employee.salaryComp);
		System.out.println("salary sort :: " + Arrays.toString(empArr));
		Arrays.sort(empArr, new AgeComparable());
		System.out.println("Age sort :: " + Arrays.toString(empArr));

		Arrays.sort(empArr, new NameComparator());
		System.out.println("Name sort :: " + Arrays.toString(empArr));

	}
}

class Employee implements Comparable<Employee> {
	public static Comparator<Employee> salaryComp = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return (int) (o1.getSalary() - o2.getSalary());
		}
	};
	private int id;
	private String name;
	private int age;
	private long salary;

	public Employee(int id, String name, int age, long salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

}

class AgeComparable implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
//		return Integer.compare(o1.getAge(), o2.getAge());
		return o1.getAge() - o2.getAge();
	}
}

class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}