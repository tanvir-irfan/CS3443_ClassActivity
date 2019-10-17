package edu.utsa.compare;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee arg0, Employee arg1) {
		return (int)(arg0.getSalary() - arg1.getSalary());
	}

}
