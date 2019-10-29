package edu.utsa.junit.test;

import junit.framework.TestCase;

public class CounterTestJunit4 extends TestCase {
	Counter counter;

	public CounterTestJunit4(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Set Up!");
		counter = new Counter();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
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
