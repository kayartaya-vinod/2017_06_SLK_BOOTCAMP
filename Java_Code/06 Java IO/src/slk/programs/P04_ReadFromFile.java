package slk.programs;

import java.io.FileInputStream;

public class P04_ReadFromFile {

	public static void main(String[] args) throws Exception {
		
		String path = "src/slk/programs/P04_ReadFromFile.java";
		FileInputStream file = new FileInputStream(path);
		int size = file.available();
		System.out.println("Total bytes in the file = " + size);
		
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		
		String fileContent = new String(bytes);
		System.out.println(fileContent);
	}
}
