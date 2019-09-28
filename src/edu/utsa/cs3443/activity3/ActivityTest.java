package edu.utsa.cs3443.activity3;

public class ActivityTest {

	public static void print2DArray(int[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
	}

	public static void print1DArray(long[] board) {
		for (int r = 0; r < board.length; r++) {
			System.out.print(board[r]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		GameOfLife.gameOfLife(board);

		ActivityTest.print2DArray(board);

		long[] res = FibonacciNumber.getFibonacciNumbers(10);
		
		ActivityTest.print1DArray(res);
	}

}
