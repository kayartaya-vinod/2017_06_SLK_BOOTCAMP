package slk.programs;

import slk.util.KeyboardUtil;

public class P03_ReadFromKeyboard {

	public static void main(String[] args) {
		
		String name;
		int age;
		double height;
		
		name = KeyboardUtil.getString("Enter your name: ");
		age = KeyboardUtil.getInt("Enter your age: ");
		height = KeyboardUtil.getDouble("Enter your height: ");
		
		System.out.printf("Name = %s\nAge = %d years\nHeight = %.2f ft.\n\n",
				name, age, height);
	}
}
