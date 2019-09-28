package edu.utsa.cs3443.activity3.solution;

/*
 * This approach does not require a new array to be created to store the result.
 * It reuses the input array, saving some valuable memory spaces!!!
 */

public class GameOfLifeSolution {

	public static void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int row = board.length;
		int col = board[0].length;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int neighbor = neighborCount(board, r, c);

				if (board[r][c] == 1) {
					switch (neighbor) {
					case 0:
					case 1:
						board[r][c] = 2; // dies, kind of keep track who just got life!
						break;
					case 2:
					case 3:
						board[r][c] = 1; // lives, not necessary to update as it already is live!
						break;
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
						board[r][c] = 2; // dies
						break;
					}
				} else {
					if (neighbor == 3) {
						board[r][c] = 3; // lives
					}
				}
			}
		}

		// 2 is an MADE UP states for the array, so change it.
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (board[r][c] == 2) {
					board[r][c] = 0;
				} else if (board[r][c] == 3) {
					board[r][c] = 1;
				}
			}
		}
	}

	private static int neighborCount(int[][] board, int r, int c) {
		// try to draw the picture and then it will be clear from where these
		// values came from!
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		int count = 0;

		for (int i = 0; i < 8; i++) {
			// if the new cell is not valid, don't check that cell for neighbor.
			// why? IndexOutOfBoundsException
			if (isValid(board, r + dr[i], c + dc[i])) {
				count++;
			}
		}

		return count;
	}

	private static boolean isValid(int[][] board, int r, int c) {
		return r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] == 1 || board[r][c] == 2);
	}

	public static void show (int [][] board) {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		
		gameOfLife(board);
		
		show(board);
	}

}
