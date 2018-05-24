package slk.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import slk.util.KeyboardUtil;

public class P02_HandlingCheckedExceptions {

	public static void main(String[] args) {
		String filename = KeyboardUtil.getString("Enter a filename: ");
		try {
			FileReader in = new FileReader(filename);
			
			try {
				int ch;
				while ((ch = in.read()) != -1) {
					System.out.print((char) ch);
				}
				
				in.close();
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Invalid filename! Rerun the code with proper filename.");
		}
	}
}
