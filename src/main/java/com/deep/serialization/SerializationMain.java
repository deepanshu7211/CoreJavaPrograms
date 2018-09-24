package com.deep.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationMain {
	public static void main(String[] args) {
		Person person = new Person("deepanshu", "saxena");
		Employee emp = new Employee(101, "deepanshu", "it");
		emp.setPerson(person);
		// emp.setEmpid(101);
		// emp.setName("deep");
		// emp.setDept("it");

		System.out.println(" ********* Doing Serialization ************* ");

		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		System.out.println(" *********** Deserialization ************* ");

		Employee emp2 = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp2 = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Emp id: " + emp2.getEmpid());
		System.out.println("Name: " + emp2.getName());
		System.out.println(" Dept  " + emp2.getDept());
		System.out.println("person :: " + emp2.getPerson());

	}

}
