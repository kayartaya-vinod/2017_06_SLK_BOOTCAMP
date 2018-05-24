package slk.programs;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;

public class P08_ReadNumbersFromFile {

	public static void main(String[] args) throws Exception {
		
		FileInputStream file = new FileInputStream("numbers.data");
		DataInputStream in = new DataInputStream(file);
		
		double num;
		
		while(true){
			try {
				num = in.readDouble();
				System.out.println(num);
			} catch (EOFException e) {
				break;
			}
		}
		
		in.close();
		file.close();
		
		System.out.println("That's all folks!");
	}
}
