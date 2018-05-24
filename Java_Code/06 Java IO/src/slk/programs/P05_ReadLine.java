package slk.programs;

import java.io.BufferedReader;
import java.io.FileReader;

public class P05_ReadLine {

	public static void main(String[] args) throws Exception {

		String path = "src/slk/programs/P04_ReadFromFile.java";
		FileReader file = new FileReader(path);

		// decorator
		BufferedReader in = new BufferedReader(file);

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		file.close();
	}
}
