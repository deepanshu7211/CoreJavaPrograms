package com.deep.serialization;

import java.io.IOException;
import java.io.Serializable;

public class Employee implements Serializable {

	// private static final long serialVersionUID = 1L;

	private int empid;
	private String name;
	private String dept;
	private Person person;

	public Employee() {
		System.out.println("defualt constructor called... ");
	}

	public Employee(int empid, String name, String dept) {
		// super(fname, lname);
		this.empid = empid;
		this.name = name;
		this.dept = dept;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.writeInt(empid);
		stream.writeObject(name);
		stream.writeObject(dept);
	}

	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		empid = stream.readInt();
		name = (String) stream.readObject();
		dept = (String) stream.readObject();
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", dept=" + dept + "]";
	}

}
