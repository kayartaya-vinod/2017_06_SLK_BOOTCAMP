package slk.programs;

import slk.entity.Person;

public class P02_UsingPersonClass {

	public static void main(String[] args) {
		// Person reference variable
		Person p1;
		p1 = new Person();
		p1.setId(12);
		p1.setName("John Doe");
		p1.setEmail("johndoe@mail.com");
		p1.setPhone("5552353344");
		
		Person p2;
		p2 = new Person(7788, "Scott", "scotty@mail.com", "5557382233");
		
		System.out.println("p1's data: ");
		System.out.println("Name = " + p1.getName());
		System.out.println("Email = " + p1.getEmail());
		System.out.println("Phone = " + p1.getPhone());
		System.out.println();
		
		System.out.println("p2's data: ");
		System.out.println("Name = " + p2.getName());
		System.out.println("Email = " + p2.getEmail());
		System.out.println("Phone = " + p2.getPhone());
		System.out.println();
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
}
