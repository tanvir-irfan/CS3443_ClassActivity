package edu.utsa.cs3443.lab2;

public class BigIntegerTest{

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
		
		// my BigInteger.java does not have any divide function, however, they should have implemented it. Uncomment the following lines for testing their code.
		/*
		
		BigInteger x = new BigInteger("12345");
		BigInteger y = new BigInteger(10);
		BigInteger z;
		z = x.add(y);
		z.show();				//prints 12355
		z = x.subtract(y);
		z.show();				//prints 12335
		y.setBigInteger("00");
		z = x.multiply(y);
		z.show();				//prints 1234500
		z = x.divide(10000);
		z.show();				//prints 123
		z = x.mod(10);
		z.show();				//prints 5
		x.increment();
		x.show();				//prints 12346
		x.decrement();
		x.show();
		*/

	}

}
