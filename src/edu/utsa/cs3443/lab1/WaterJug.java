package edu.utsa.cs3443.lab1;

/**
 * 
 * @author 
 * Taken from someone's submission.
 *
 */

public class WaterJug {
	private int capacity;
	private String name;
	private int currentAmount;
	private boolean broken = false;

	public WaterJug(int cap) {
		this(cap, "");
	}

	public WaterJug(int cap, String n) {
		setCapacity(cap);
		name = n;
		currentAmount = 0;
	}

	public WaterJug(String n) {
		name = n;
		currentAmount = 0;
	}

	int fillWater(int amount) {
		if (broken)
			return 0;
		int remainingCapacity = capacity - currentAmount;
		if (remainingCapacity >= amount) {
			currentAmount += amount;
			return amount;
		} else {
			currentAmount = capacity;
			return remainingCapacity;
		}
	}

	int drinkWater(int amount) {
		if (broken)
			return 0;
		if (amount > currentAmount) {
			int amountDrunk = currentAmount;
			currentAmount = 0;
			return amountDrunk;
		} else {
			currentAmount -= amount;
			return amount;
		}
	}

	void breakJug() {
		currentAmount = 0;
		broken = true;

	}

	void describeJug() {
		System.out.print("Name: \"" + name + "\", ");
		if (broken)
			System.out.println("Unfortunately, the jug is broken!");
		else
			System.out.println("capacity = " + capacity + ", Current Water Level = " + currentAmount);
	}

	void setName(String n) {
		name = n;
	}

	void setCapacity(int cap) {
		if (cap >= 0) {
			if (cap <= currentAmount) {
				currentAmount = cap;
			}
			capacity = cap;
		} else {
			System.out.println("Capacity must be a positive value.");
		}

	}

}
