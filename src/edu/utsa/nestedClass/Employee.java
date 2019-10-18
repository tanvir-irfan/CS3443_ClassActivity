package edu.utsa.nestedClass;

import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	
	private class Address {
		public String streetName;
		public String addressLineOne;
		public String addressLineTwo;
		
		public String city;
		public String state;
		
		Address() {
			
		}
		
		
	}
	
	private int id;
	private String name;
	private int age;
	private long salary;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

	public Employee(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee emp) {
		return (this.id - emp.id);
	}

	@Override
	// overridden to print the user-friendly information about the Employee
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
	}

	public static void main(String[] args) {
		// sorting object array
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Susan", 35, 5000);
		empArr[3] = new Employee(1, "Malisa", 32, 50000);

		// sorting employees array using Comparable interface implementation
		Arrays.sort(empArr);
		System.out.println("Default Sorting of Employees list:\n" + Arrays.toString(empArr));
	}
}