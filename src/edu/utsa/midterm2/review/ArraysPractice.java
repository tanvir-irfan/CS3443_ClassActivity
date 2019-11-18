package edu.utsa.midterm2.review;

public class ArraysPractice {

	public static void main(String[] args) {
		int [][] arr = new int[5][5];
		
		populateArrayRowWise(arr);
		printArray(arr);
	}

	public static void populateArrayRowWise(int[][] array) {
		System.out.println("Populating Row Wise");
		// TODO WRITE YOUR CODE HERE
		int count = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (i == j) {
					array[i][j] = count * count++;
				} else {
					array[i][j] = count++;
				}
			}
		}
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
