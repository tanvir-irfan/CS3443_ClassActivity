package edu.utsa.midterm2.review;

public class StringsPractice {

	public static void main(String[] args) {
		String sentence = "Let prepare for the midterm";
		
		System.out.println(reverseWords(sentence));
	}

	public static String reverseWords(String s) {
		s = s.trim();

		String[] sArr = s.split(" ");
		
		int index = 0;
		for (String word : sArr) {
			sArr[index++] = reverse(word);
		}
		
		return stringArrToString(sArr);
	}

	private static String reverse(String s) {
		if (s == null || s.length() < 2)
			return s;

		char[] sArr = s.toCharArray();

		int len = s.length();

		for (int i = 0; i < len / 2; i++) {
			char temp = sArr[i];
			sArr[i] = sArr[len - 1 - i];
			sArr[len - 1 - i] = temp;
		}

		return new String(sArr);
	}
	
	private static String stringArrToString(String [] sArr) {
		StringBuilder sb = new StringBuilder();

		for (String word : sArr) {
			sb.append(word).append(" ");
		}

		return sb.toString().trim();
	}
}
