package slk.programs;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import slk.util.KeyboardUtil;

public class P07_WriteNumbersToFile {

	public static void main(String[] args) throws Exception {

		// target
		FileOutputStream file = new FileOutputStream("numbers.data", true);
		// decorator (lots of functions to write)
		DataOutputStream out = new DataOutputStream(file);

		while (true) {
			String input = KeyboardUtil.getString("Enter a number (0 to stop): ");
			try {
				double num = Double.parseDouble(input);
				if (num == 0) {
					break;
				}
				out.writeDouble(num);
			} catch (NumberFormatException e) {
				System.out.println("Please enter only numerical data!");
			}
		}
		
		out.close();
		file.close();
		System.out.println("Numbers were written to the file successfully!");

	}
}
