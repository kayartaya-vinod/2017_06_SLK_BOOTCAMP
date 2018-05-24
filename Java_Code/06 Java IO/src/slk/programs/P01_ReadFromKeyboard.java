package slk.programs;

public class P01_ReadFromKeyboard {

	public static void main(String[] args) throws Exception {

		int ch;
		String name = "";
		
		System.out.println("Enter your name: ");
		while ((ch = System.in.read()) != '\n') {
			name += (char)ch;
		}
		
		System.out.println("Hello, " + name);

	}
}
