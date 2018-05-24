package slk.programs;

import java.io.FileInputStream;

public class P03_ReadFromFile {

	public static void main(String[] args) throws Exception {
		String path = "src/slk/programs/P01_ReadFromKeyboard.java";
		FileInputStream in = new FileInputStream(path);

		int ch;
		while ((ch = in.read()) != -1) {
			System.out.print((char) ch);
		}
		in.close();
		
	}
}
