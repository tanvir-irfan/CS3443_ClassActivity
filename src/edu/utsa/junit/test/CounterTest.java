package edu.utsa.junit.test;

import junit.framework.TestCase;

public class CounterTest extends TestCase {
	Counter counter;

	// default constructor
	public CounterTest() {
	}

	protected void setUp() { // creates a (simple) test fixture
		System.out.println("Set Up!");
		counter = new Counter();
	}

	// no resources to release
	protected void tearDown() {
		System.out.println("Tear Down!");
	}

	public void testIncrement() {
		assertTrue(counter.increment() == 1);
		assertTrue(counter.increment() == 2);
	}

	public void testDecrement() {
		assertTrue(counter.decrement() == -1);
	}
} 