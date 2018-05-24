package slk.programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import slk.entity.Person;

public class P10_ReadObjectsFromFile {

	public static void main(String[] args) throws Exception {
		
		FileInputStream file = new FileInputStream("persons.data");
		ObjectInputStream in = new ObjectInputStream(file);
		
		while(true){
			try {
				Object obj = in.readObject();
				if(obj instanceof Person){
					Person p = (Person) obj;
					System.out.printf("%s is %.2f ft. tall\n", p.getName(), p.getHeight());
				}
			} catch (IOException e) {
				break;
			}
		}
		in.close();
		file.close();
		
	}
}
