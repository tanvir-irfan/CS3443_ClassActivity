package edu.utsa.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {

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

	public Employee(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee emp) {
		// let's sort the employee based on an id in ascending order
		// returns a negative integer, zero, or a positive integer as this
		// employee id
		// is less than, equal to, or greater than the specified object.
		return (this.id - emp.id); // 10 - 20 = -10
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

		// empArr[0].compareTo(empArr[1]);

		// sorting employees array using Comparable interface implementation
		Arrays.sort(empArr);
		System.out.println("Default Sorting of Employees list:\n" + Arrays.toString(empArr));

		// sorting employees array using Comparable interface implementation
		Arrays.sort(empArr, new AgeComparator());
		System.out.println("Comparator to sort employees list or array in order of Age:\n" + Arrays.toString(empArr));

		/**
		 * Comparator to sort employees list or array in order of Salary
		 */
		Comparator<Employee> salaryComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return (int) (e1.getSalary() - e2.getSalary());
			}
		};

		Arrays.sort(empArr, salaryComparator);
		System.out.println("Comparator to sort employees list or array in order of Salary:\n" + Arrays.toString(empArr));
		
		Comparator<Employee> salaryComparatorLambda = 
				(Employee e1, Employee e2) -> (int) (e1.getSalary() - e2.getSalary());
		
		Arrays.sort(empArr, salaryComparatorLambda);
		System.out.println("Comparator to sort employees list or array in order of Salary (with lambda expression):\n" + Arrays.toString(empArr));
		
		
		Arrays.sort(empArr,
				( Employee e1, Employee e2) -> { return ((int) (e1.getSalary() - e2.getSalary())); } );
		
		Arrays.sort(empArr,
				( Employee e1, Employee e2) -> ((int) (e1.getSalary() - e2.getSalary())) );
		System.out.println("Comparator to sort employees list or array in order of Salary (with lambda expression):\n" + Arrays.toString(empArr));
	}
}