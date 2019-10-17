package edu.utsa.compare;

import java.util.Arrays;

public class ComparatorTest {

	public static void main(String[] args) {
		// sorting object array
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Susan", 35, 5000);
		empArr[3] = new Employee(1, "Malisa", 32, 50000);

//		sorting employees array using Comparable interface implementation
//		Arrays.sort(empArr);
//		System.out.println("Default Sorting of Employees list:\n" + Arrays.toString(empArr));
		
		Arrays.sort(empArr, new NameComparator());
		System.out.println("Sorting of Employees based on Name:\n" + Arrays.toString(empArr));
		
//		NameComparator n = new NameComparator();
//		
//		n.compare(empArr[0], empArr[1]);
		
		Arrays.sort(empArr, new AgeComparator());
		System.out.println("Sorting of Employees based on Age:\n" + Arrays.toString(empArr));
		
		Arrays.sort(empArr, new SalaryComparator());
		System.out.println("Sorting of Employees based on Salary:\n" + Arrays.toString(empArr));
	}

}
