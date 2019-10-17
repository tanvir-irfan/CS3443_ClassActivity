package edu.utsa.compare;

import java.util.Arrays;

public class EmployeeInitial {

	private int id;
	private String name;
	private int age;
	private long salary;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getSalary() {
		return salary;
	}

	public EmployeeInitial(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	// this is overridden to print the user-friendly information about the
	// Employee
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
	}
	
	public static void main(String[]args) {
			//sorting object array
			EmployeeInitial[] empArr = new EmployeeInitial[4];
			empArr[0] = new EmployeeInitial(10, "Mikey", 25, 10000);
			empArr[1] = new EmployeeInitial(20, "Arun", 29, 20000);
			empArr[2] = new EmployeeInitial(5, "Lisa", 35, 5000);
			empArr[3] = new EmployeeInitial(1, "Pankaj", 32, 50000);

			//sorting employees array using Comparable interface implementation
			Arrays.sort(empArr);
			System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));
	}
}