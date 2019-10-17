package edu.utsa.compare;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee arg0, Employee arg1) {
		
		return arg0.getName().compareToIgnoreCase(arg1.getName());
	}

}
