package slk.programs;

import java.io.FileWriter;
import java.io.PrintWriter;

import slk.util.KeyboardUtil;

public class P06_CreateBusinessCard {

	public static void main(String[] args) throws Exception {

		String name = KeyboardUtil.getString("Enter a name: ");
		String email = KeyboardUtil.getString("Enter email: ");
		String phone = KeyboardUtil.getString("Enter phone: ");

		int index = name.indexOf(" ") == -1 ? name.length() : name.indexOf(" ");
		String cardName = name.substring(0, index).toLowerCase() + ".txt";

		FileWriter file = new FileWriter(cardName);
		PrintWriter out = new PrintWriter(file);

		out.printf("Name: %s\n", name);
		out.printf("Email: %s\n", email);
		out.printf("Phone: %s\n", phone);

		out.close();
		file.close();

		System.out.println("Card written!");
	}
}
