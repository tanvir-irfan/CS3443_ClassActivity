package edu.utsa.cs3443.activity2;

public class Rectangle extends Shape {
		
	Rectangle (String name) {
		super(name);
//		super();
		
		
		System.out.println("This is the constructor in Rectangle Class!");
	}
	
	@Override
	public void draw() {
		System.out.println("This is drawing a Rectangle named = " + this.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
