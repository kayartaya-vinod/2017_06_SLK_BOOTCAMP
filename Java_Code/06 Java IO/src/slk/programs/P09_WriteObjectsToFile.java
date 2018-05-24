package slk.programs;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import slk.entity.Person;
import slk.util.KeyboardUtil;

public class P09_WriteObjectsToFile {

	public static void main(String[] args) throws Exception {
		FileOutputStream file = new FileOutputStream("persons.data");
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		while(true){
			String name = KeyboardUtil.getString("Enter name: ");
			double height = KeyboardUtil.getDouble("Enter height: ");
			Person p = new Person(name, height);
			
			out.writeObject(p);
			String choice = KeyboardUtil.getString("Enter 'quit' to stop, hit RETURN to continue: ");
			
			if(choice.equalsIgnoreCase("quit")){
				break;
			}
		}
		
		out.close();
		file.close();
		System.out.println("Data stored in the file!");
	}
}
