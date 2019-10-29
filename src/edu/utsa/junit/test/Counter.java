package edu.utsa.junit.test;

public class Counter {

	int count = 0;
	
	public int decrement() {
		return --count;
	}

	public int increment() {
		return ++count;
	}

}
