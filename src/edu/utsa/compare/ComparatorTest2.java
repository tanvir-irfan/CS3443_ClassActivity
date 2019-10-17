package edu.utsa.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest2 {

	/**
	 * Comparator to sort employees list or array in order of Salary
	 */
	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return (int) (e1.getSalary() - e2.getSalary());
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Age
	 */
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Name
	 */
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};

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

		Arrays.sort(empArr, ComparatorTest2.NameComparator);
		System.out.println("Sorting of Employees based on Name:\n" + Arrays.toString(empArr));

		Arrays.sort(empArr, ComparatorTest2.AgeComparator);
		System.out.println("Sorting of Employees based on Age:\n" + Arrays.toString(empArr));

		Arrays.sort(empArr, ComparatorTest2.SalaryComparator);
		System.out.println("Sorting of Employees based on Salary:\n" + Arrays.toString(empArr));
	}

}
