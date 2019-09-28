package edu.utsa.cs3443.activity3;

/*
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, 
 * called the Fibonacci sequence, such that each number is 
 * the sum of the two preceding ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * 
 * Given an integer n, return an array of first n-fibonacci numbers.
 */

public class FibonacciNumber {

	public static long[] getFibonacciNumbers(int n) {
		if (n < 0) return new long[0];
		long [] res = new long[n + 1];
		
		// WRITE YOUR CODE HERE
		res[0] = 0;
		if(n == 0) return res;
		res[1] = 1;
		if(n == 1) return res;
		
		for(int i = 2; i < res.length; i++) {
			res[i] = res[i-1] + res[i-2];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		long [] res = getFibonacciNumbers(100);
		
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
