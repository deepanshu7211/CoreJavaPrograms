package com.deep.collectns;

/**
 * Created by deepanshu.saxena on 14/03/16.
 */
public class MyWildcardEx {
    public static void main(String[] args) {
        MyEmployeeUtil<CompAEmp> empA
                = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Ram", 20000));
        MyEmployeeUtil<CompBEmp> empB
                = new MyEmployeeUtil<CompBEmp>(new CompBEmp("Krish", 30000));
        MyEmployeeUtil<CompAEmp> empC
                = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Nagesh", 20000));
        System.out.println("Is salary same? " + empA.isSalaryEqual(empB));
        System.out.println("Is salary same? " + empA.isSalaryEqual(empC));

    }
}


class MyEmployeeUtil<T extends Emp> {
    private T emp;

    public MyEmployeeUtil(T emp) {
        this.emp = emp;
    }

    public int getSalary() {
        return emp.getSalary();
    }

    public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp) {

        if (emp.getSalary() == otherEmp.getSalary()) {
            return true;
        }
        return false;
    }

}

class CompBEmp extends Emp {

    public CompBEmp(String name, int salary) {
        super(name, salary);
    }
}

class CompAEmp extends Emp {

    public CompAEmp(String name, int salary) {
        super(name, salary);
    }
}

class Emp {
    private String name;
    private int salary;

    public Emp(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}