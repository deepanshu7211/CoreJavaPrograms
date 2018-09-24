package com.deep.collectns;

public class ClonableExample {
	public static void main(String[] args) throws CloneNotSupportedException {

		// Shallow Copy
		// Department dept = new Department("hr");
		// EmpNew org = new EmpNew("deeo", dept);
		// EmpNew cloned = (EmpNew) org.clone();
		// System.out.println(org.equals(cloned));
		// cloned.getDept().setDeptName("finance");
		// System.out.println(org.getDept().getDeptName()); // Change in Clone
		// // Object is
		// // changing original

		// Deep Cloning

		Department dept = new Department("hr");
		EmpNew org = new EmpNew("deeo", dept);
		EmpNew cloned = (EmpNew) org.clone();
		System.out.println(org.equals(cloned));
		cloned.getDept().setDeptName("finance");
		System.out.println(org.getDept().getDeptName());
		System.out.println(cloned.getDept().getDeptName());

	}

}

class EmpNew implements Cloneable {
	private String name;
	private Department dept;

	public EmpNew(String name, Department dept) {

		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		EmpNew clone = (EmpNew) super.clone();
		clone.setDept((Department) clone.getDept().clone());
		return clone;
	}

	@Override
	public String toString() {
		return "EmpNew [name=" + name + ", dept=" + dept + "]";
	}

}

class Department implements Cloneable {
	private String deptName;

	public Department(String deptName) {

		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}