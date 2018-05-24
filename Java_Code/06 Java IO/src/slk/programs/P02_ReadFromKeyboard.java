package slk.programs;

public class P02_ReadFromKeyboard {

	public static void main(String[] args) throws Exception {

		byte[] buff = new byte[10];

		System.out.println("Enter your name: ");
		System.in.read(buff);

		String name = new String(buff);
		// String name = new String(buff).trim();
		System.out.printf("Hello ***%s***\n", name);

		System.out.println("length of name is " + name.length());

		for (int i = 0; i < name.length(); i++) {
			int ch = name.charAt(i);
			System.out.println(ch);
		}
	}
}
