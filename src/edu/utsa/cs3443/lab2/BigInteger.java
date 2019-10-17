package edu.utsa.cs3443.lab2;

import java.util.Arrays;

/**
 * @author Tanvir Irfan Chowdhury
 * 
 *         This class represents a BigInteger number using a character array of
 *         size {@link MAX_SIZE}.
 * 
 *         Numbers are represented reverse order of the digits! For example,
 *         123456 is stored in the array as {'6' '5' '4' '3' '2' '1'}
 * 
 *         When writing code, it is good idea to keep MAX_SIZE to a small
 *         number! This will help you to DEBUG your code easily.
 */
public class BigInteger implements Comparable<BigInteger> {

	char[] number;
	private static int MAX_SIZE = 1000;

	BigInteger() {
		this(0);
	}

	BigInteger(String num) {
		this(num.toCharArray());
	}

	BigInteger(long n) {
		this("" + n);
	}

	BigInteger(char a[]) {
		this.setBigInteger(a);
	}

	void setBigInteger(long n) {
		this.setBigInteger("" + n);
	}

	void setBigInteger(String num) {
		this.setBigInteger(num.toCharArray());
	}

	void setBigInteger(char a[]) {

		if (this.number == null) {
			this.number = new char[MAX_SIZE];
			Arrays.fill(this.number, '0');
		}

		reverse(a);

		// ignoring number which has more than MAX_SIZE digit.
		int len = Math.min(a.length, MAX_SIZE);

		for (int i = 0; i < len; i++) {
			this.number[i] = a[i];
		}
	}

	/**
	 * 
	 * @param other
	 * @return sum of the two BigIntegers
	 */
	BigInteger add(BigInteger other) {
		BigInteger result = new BigInteger();

		int carry = 0;

		for (int i = 0; i < MAX_SIZE; i++) {
			int a = charToInt(this.number[i]);
			int b = charToInt(other.number[i]);

			int tempRes = a + b + carry;

			carry = tempRes / 10;

			tempRes %= 10;

			result.number[i] = intToChar(tempRes);
		}

		return result;
	}

	/**
	 * 
	 * @return the (incremented) current BigInteger number
	 */
	BigInteger increment() {
		BigInteger res = this.add(new BigInteger(1));

		this.number = res.number;

		return this;
	}

	/**
	 * 
	 * @param other
	 * @return a BigInteger witch is the result of this.number * other.number
	 * 
	 *         IDEA: Keep a running sum, initialized to 0. Keep the first number
	 *         in a integer array Take one digit at a time from the second array
	 * 
	 *         Multiplication of these two will give you an array
	 * 
	 *         Shift the array to simulate multiplication by 10th, 100th...
	 *         digits of second num.
	 * 
	 *         Add this shifted multiplication to your running sum!!!!
	 * 
	 *         When you ran out of digits in the second number, you are done
	 *         (except some formatting).
	 * 
	 *         Do the formatting and you are done!
	 */
	BigInteger multiply(BigInteger other) {
		int[] resArray = new int[MAX_SIZE];

		int[] thisNumber = convertToIntArray(this.number);
		int[] otherNumber = convertToIntArray(other.number);

		for (int i = 0; i < MAX_SIZE; i++) {
			int digit = otherNumber[i];

			int[] tempMulResult = multiplyByIntDigit(thisNumber, digit);

			tempMulResult = shift(tempMulResult, i);

			resArray = addTwoArrays(resArray, tempMulResult);
		}

		// Let us assume, the MAX_SIZE = 20;
		// firstNumber = "123456789", secondNumber = "123"
		// at this point the result of our multiplication is kind of
		// [7, 4, 0, 5, 8, 1, 5, 8, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		// which is the correct result, however, it is reverse with some leading
		// zeros!!!!
		// next couple of lines straightened the number.
		// keep in mind that in our setBigInteger() method,
		// we reverse the number, i.e., 123 -> 321.

		char[] resCharArray = convertToCharArray(resArray);

		int numLen = MAX_SIZE - 1;

		while (numLen > 0 && resCharArray[numLen] == '0') {
			numLen--;
		}

		StringBuffer actualRes = new StringBuffer(new String(resCharArray).substring(0, numLen + 1)).reverse();

		return new BigInteger(actualRes.toString());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		boolean flag = false;

		for (int i = MAX_SIZE - 1; i >= 0; i--) {
			if (!flag && this.number[i] != '0') {
				flag = true;
			}

			if (flag) {
				sb.append(this.number[i]);
			}
		}

		if (sb.length() == 0) {
			sb.append('0');
		}

		return sb.toString();
	}

	@Override
	public int compareTo(BigInteger other) {
		int i = 0;
		for (i = MAX_SIZE - 1; i >= 0; i--) {
			if (this.number[i] != other.number[i]) {
				break;
			}
		}

		if (i < 0)
			return 0;

		int a = charToInt(this.number[i]);
		int b = charToInt(other.number[i]);

		return a - b;
	}

	public void show () {
		System.out.println(this.toString());
	}
	
	//////////////////////////////////////////////////////////////////
	/**
	 * Simple reverse of an array!
	 * 
	 * @param num
	 */
	private void reverse(int[] num) {
		int len = num.length;
		for (int i = 0; i < len / 2; i++) {
			int temp = num[i];
			num[i] = num[len - i - 1];
			num[len - i - 1] = temp;
		}
	}

	/**
	 * Simple reverse of an array!
	 * 
	 * @param num
	 */
	private void reverse(char[] num) {
		int len = num.length;
		for (int i = 0; i < len / 2; i++) {
			char temp = num[i];
			num[i] = num[len - i - 1];
			num[len - i - 1] = temp;
		}
	}

	private int charToInt(char digit) {
		return digit - '0';
	}

	private char intToChar(int digit) {
		return (char) (digit + '0');
	}

	/**
	 * 
	 * @param num
	 * @return given an int array convert it to an char array
	 */
	private char[] convertToCharArray(int[] num) {
		char[] res = new char[num.length];
		for (int i = 0; i < num.length; i++) {
			res[i] = intToChar(num[i]);
		}

		return res;
	}

	/**
	 * 
	 * @param num
	 * @return given an char array convert it to an int array
	 */
	private int[] convertToIntArray(char[] num) {
		int[] res = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			res[i] = charToInt(num[i]);
		}

		return res;
	}

	/**
	 * 
	 * @param num
	 * @param digit
	 * @return an array, result of the array multiplied by the digit
	 */
	private int[] multiplyByIntDigit(int[] num, int digit) {
		int[] result = new int[MAX_SIZE];

		for (int i = 1; i <= digit; i++) {
			result = addTwoArrays(result, num);
		}

		return result;
	}

	private int[] shift(int[] num, int pos) {
		if (pos == 0)
			return num;

		for (int i = MAX_SIZE - pos - 1; i >= 0; i--) {
			num[i + pos] = num[i];
		}

		for (int i = pos - 1; i >= 0; i--) {
			num[i] = 0;
		}
		return num;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return simple addition of the two arrays.
	 */
	int[] addTwoArrays(int[] first, int[] second) {
		int[] result = new int[MAX_SIZE];

		int carry = 0;

		for (int i = 0; i < MAX_SIZE; i++) {

			int tempRes = first[i] + second[i] + carry;

			carry = tempRes / 10;

			tempRes %= 10;

			result[i] = tempRes;
		}

		return result;
	}

	public static void main(String[] args) {
		BigInteger first, second;

		String num = "99999999999";
		BigInteger b = new BigInteger();

		System.out.println(b.toString());

		b.setBigInteger("99999999999");

		System.out.println(b.toString());

		String num2 = "1";

		BigInteger c = new BigInteger(num2);

		BigInteger d = c.add(b);

		System.out.println(c.toString());
		System.out.println(c.increment());

		System.out.println(c.toString());

		first = new BigInteger("123456789");
		second = new BigInteger("123");

		System.out.println(first.multiply(second).toString());
		System.out.println(first.add(second).toString());

		System.out.println(first.increment().toString());

		System.out.println(first.multiply(second).toString());
		System.out.println(first.add(second).toString());

		System.out.println(first.increment().toString());

		int res = second.compareTo(new BigInteger("1234"));

		System.out.println(res);

		first = new BigInteger("12345678901234567654632498739473");
		second = new BigInteger("12345678901234561247612748612746");

		System.out.println(first.multiply(second).toString());

		first = new BigInteger(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678901654632498739473");
		second = new BigInteger(
				"123456789012345678901234567890123456789012345678901234567890123456789012345678961247612748612746");

		System.out.println(first.multiply(second).toString());

	}

}
