package slk.programs;

import java.util.ArrayList;
import java.util.List;

public class P01_ListDemo {
	public static void main(String[] args) {

		List<String> list;

		list = new ArrayList<String>();

		list.add("Vinod");
		list.add("Kumar");
		list.add("Vinay");
		list.add("Vinod");
		list.add("John");
		list.add("Jane");

		System.out.println(list);
		System.out.println("-------- Old method prior to Java 1.5 --------");
		for (int i = 0, j = list.size(); i < j; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		System.out.println("-------- Enhanced for loop (for each) Java 1.5 and above --------");

		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("----------------");
	}
}
