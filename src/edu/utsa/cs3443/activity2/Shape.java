package edu.utsa.cs3443.activity2;

public abstract class Shape {
	String name;
	private static int count = 0;
	public abstract void draw();
	
	Shape(String name) {
		
		super();
		
		this.name = name + " " + count++;
		System.out.println("This is the constructor in Shape Class!");
	}
	
	public static void main(String [] args) {
//		Shape s = new Shape();
	}
}
