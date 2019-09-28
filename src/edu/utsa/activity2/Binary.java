package edu.utsa.activity2;

import java.util.Arrays;

public class Binary {

	private char[] number;

	private static String NUM_FORMAT_EXCP_MST = "Binary number can not have digit other than 0 and 1";
	private static String AOB_EXCP_MST = "Are you trying to access an index that is less than 0 or greater than 31?";

	public Binary() {
		this("");
	}

	public Binary(String numStr) {
		this(numStr.toCharArray());
	}

	public Binary(char num[]) {

		this.number = new char[32];

		Arrays.fill(this.number, '0');

		this.setBigInteger(num);
	}

	public void setBigInteger(char a[]) {
		int i = this.number.length - 1, j = a.length - 1;
		while (i >= 0 && j >= 0) {
			this.number[i--] = a[j--];
		}
	}

	public void invertBits() throws NumberFormatException {
		for (int i = 0; i < this.number.length; i++) {
			switch (this.number[i]) {
			case '0':
				this.number[i] = '1';
				break;
			case '1':
				this.number[i] = '0';
				break;
			default:
				throw new NumberFormatException(NUM_FORMAT_EXCP_MST);
			}
		}
	}

	public char getBit(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.number.length)
			throw new IndexOutOfBoundsException(AOB_EXCP_MST);
		return number[index];
	}

	public void setBit(int index, char val) throws IndexOutOfBoundsException, NumberFormatException {
		if (index < 0 || index > this.number.length)
			throw new IndexOutOfBoundsException();
		if (val != '0' || val != '1')
			throw new NumberFormatException(NUM_FORMAT_EXCP_MST);
		number[index] = val;
	}

	public Binary and(Binary n) {
		Binary res = new Binary();

		for (int i = 0; i < this.number.length; i++) {
			res.number[i] = this.andBit(this.number[i], n.number[i]);
		}

		return res;
	}

	public char andBit(char a, char b) throws NumberFormatException {
		char res = 'X';
		switch (a) {
		case '0':
			switch (b) {
			case '0':
				res = '0';
				break;
			case '1':
				res = '0';
				break;
			default:
				throw new NumberFormatException(NUM_FORMAT_EXCP_MST);
			}
			break;
		case '1':
			switch (b) {
			case '0':
				res = '0';
				break;
			case '1':
				res = '1';
				break;
			default:
				throw new NumberFormatException(NUM_FORMAT_EXCP_MST);
			}
			break;
		default:
			throw new NumberFormatException(NUM_FORMAT_EXCP_MST);
		}
		return res;
	}

	public Binary or(Binary n) {
		Binary res = new Binary();
		// implement similar code as and but use different truth table
		return res;
	}

	public Binary xor(Binary n) {
		Binary res = new Binary();
		// implement similar code as and but use different truth table
		return res;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		boolean flag = false;

		for (int i = 0; i < this.number.length; i++) {
			if (!flag && this.number[i] == '1') {
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

	public void show() {
		System.out.println(this.toString());
	}

	public int decimal() {
		int result = 0;
		
		for(int i = 0; i < this.number.length; i++) {
			int power = this.number.length - 1 - i;
			
			int powerOfTwo = (int)Math.pow(2, power);
			
			result += this.number[i] == '1' ? powerOfTwo : 0;
		}
		
		return result;
	}

	public String hexadecimal() {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		StringBuffer sb = new StringBuffer();

		int leftIndex = 0;

		while (leftIndex < this.number.length) {
			int rightIndex = leftIndex + 4;

			char[] binDigitsToConvert = Arrays.copyOfRange(this.number, leftIndex, rightIndex);

			String binaryString = new String(binDigitsToConvert);

			int index = Integer.valueOf(binaryString, 2);

			char hexDigit = hexDigits[index];

			// removing leading zeros
			if (sb.length() != 0 || hexDigit != '0') {
				sb.append(hexDigit);
			}

			leftIndex = rightIndex;
		}

		// edge case: number itself is zero
		if (sb.length() == 0) {
			sb.append('0');
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Binary x = new Binary();
		char[] num = { '1', '0', '1' };
		 Binary y = new Binary(num);
		
		 x.show();
		
		 y.show();
		
		 x.invertBits();
		
		 x.show();
		
		 y.invertBits();
		
		 y.show();
		
		 // x.setBit(100, '0');
		
		 num = new char[] { '1', '0', '1' };
		 Binary z = new Binary(num);
		
		 x.and(z).show();
		
		 z.invertBits();
		
		 x.and(z).show();

		num = new char[] { '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1' };

		x = new Binary(num);

		System.out.println(x.hexadecimal());
		
		System.out.println(x.decimal());
	}
}
