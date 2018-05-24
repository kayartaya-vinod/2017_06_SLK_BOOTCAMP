package slk.programs;

import slk.entity.Employee;
import slk.entity.Person;

public class P04_InheritanceDemo {

	public static void main(String[] args) {
		
		final Employee e1; // reference
		e1 = new Employee(); // instance
		
		Employee e2 = new Employee(
				123, "John Doe", "johndoe@mail.com", "55533223456", 
				56000, "Administration");
		
		System.out.println("e1 instanceof Employee is " + (e1 instanceof Employee));
		System.out.println("e1 instanceof Person is " + (e1 instanceof Person));
		System.out.println("e1 instanceof Object is " + (e1 instanceof Object));
		
		e1.setId(7788);
		e1.setId(1235);
		e1.setName("Ross Scott");
		e1.setEmail("scott.ross@hotmail.com");
		e1.setPhone("555 222 3345");
		System.out.println("e1.hashCode() is " + e1.hashCode());
		System.out.println(e1);
		System.out.println(e2);
		
		
		e1.print();
		e2.print();
		
		
	}
}
