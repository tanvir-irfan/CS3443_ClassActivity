package edu.utsa.cs3443.activity3;

/*
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using 
the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population..
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.


Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, 
where births and deaths occur simultaneously.

Input: 

	0	1	0
	0	0	1
	1	1	1
	0	0	0

Output: 

	0	0	0
	1	0	1
	0	1	1
	0	1	0


 */

public class GameOfLife {

	public static void gameOfLife(int[][] board) {
		// WRITE YOUR FUNCTION HERE!!!!
	}
	
	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		GameOfLife.gameOfLife(board);

		ActivityTest.print2DArray(board);
	}

}
