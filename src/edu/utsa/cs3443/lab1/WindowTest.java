package edu.utsa.cs3443.lab1;

public class WindowTest {

	public static void main(String[] args) {
		Window w1 = new Window("First");
		Window w2 = new Window("Second", 10, 10, 300, 200);
		
		
		Window w3 = new Window("Second", 10, 10, -300, -200);
		
		w2.show();
		w1.restore();
		w1.show();
		w2.maximize();
		w2.setPosition(50, 50);
		w2.setSize(-100, 100);
		w2.show();
		w2.restore();
		w2.show();
		w1.setPosition(100, 10);
		w1.moveBy(5, -5);
		w1.show();
	}

}
