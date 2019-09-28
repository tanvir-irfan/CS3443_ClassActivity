package edu.utsa.cs3443.activity2;

public class TestClass {

	public static void main(String[] args) {
		Shape [] sArray = new Shape[10];
		
		Rectangle r1 = new Rectangle("Rectangle");
		Rectangle r2 = new Rectangle("Rectangle");
		Rectangle r3 = new Rectangle("Rectangle");
		Rectangle r4 = new Rectangle("Rectangle");
		
		Circle c1 = new Circle("Circle");
		Circle c2 = new Circle("Circle");
		Circle c3 = new Circle("Circle");
		Circle c4 = new Circle("Circle");
		
		Cylinder c5 = new Cylinder("Cylinder");
		Cylinder c6 = new Cylinder("Cylinder");
		
		sArray[0] = r1;
		sArray[1] = c1;
		sArray[2] = c5;
		sArray[3] = c6;
		sArray[4] = r2;
		sArray[5] = c2;
		sArray[6] = r3;
		sArray[7] = r4;
		sArray[8] = c3;
		sArray[9] = c4;
		
		for(Shape s : sArray) {
			s.draw();
		}
	}

}
