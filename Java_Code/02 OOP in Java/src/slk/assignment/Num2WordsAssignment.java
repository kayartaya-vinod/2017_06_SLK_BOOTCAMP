package slk.assignment;

import slk.util.KeyboardUtil;

public class Num2WordsAssignment {
	
	static String num2words(int num){
		return null;
	}
	
	public static void main(String[] args) {

		int num = KeyboardUtil.getInt("Enter a number between 1 and 99,99,99,999: ");
		// TODO: add validation here
		
		String inWords = num2words(num);
		System.out.println(inWords);
	}
}
