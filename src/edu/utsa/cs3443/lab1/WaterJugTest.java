package edu.utsa.cs3443.lab1;

public class WaterJugTest {
	public static void main(String[] args) {
		WaterJug jug1 = new WaterJug("My Coffee Jug");
		jug1.setCapacity(10);
		jug1.fillWater(5);
		jug1.describeJug();

		jug1.drinkWater(8);

		jug1.describeJug();

		jug1.breakJug();
		jug1.describeJug();

		System.out.println();
		WaterJug jug2 = new WaterJug(15, "MyJuggy");
		jug2.describeJug();
		jug2.fillWater(20);
		jug2.describeJug();
		jug2.drinkWater(30);
		jug2.describeJug();
		jug2.fillWater(10);
		// jug2.breakJug();
		jug2.setCapacity(-5);
		jug2.describeJug();

	}
}
