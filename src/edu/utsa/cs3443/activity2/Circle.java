package edu.utsa.cs3443.activity2;

public class Circle extends Shape {
	
	Circle (String name) {
		super(name);
		System.out.println("This is the constructor in Circle Class!");
	}
	
	@Override
	public void draw() {
		System.out.println("This is drawing a Circle named = " + this.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
