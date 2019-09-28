package edu.utsa.cs3443.activity2;

public class Cylinder extends Circle {
		
	Cylinder (String name) {
		super(name);
		System.out.println("This is the constructor in Cylinder Class!");
	}
	
	@Override
	public void draw() {
		System.out.println("This is drawing a Cylinder named = " + this.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
