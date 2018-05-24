package slk.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P04_ComparatorDemo {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Vinod Kumar Kayartaya");
		names.add("Vinay KM");
		names.add("Satya");
		names.add("Radha");
		names.add("Shyam Sundar KC");
		names.add("Naveen");
		names.add("John Doe");
		names.add("Jane Doe");

		print(names);
		Collections.sort(names);
		print(names);

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		print(names);
		
		// Lambda expressions / arrow functions, works with Java 1.8 + only
		Collections.sort(names, (s1, s2) -> s2.length() - s1.length());
		print(names);

	}

	public static void print(List<String> names) {
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("-------------");
	}

}







