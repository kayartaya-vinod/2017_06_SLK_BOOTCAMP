package slk.programs;

import slk.entity.Employee;

public class P04_NullPointerExceptionDemo {

	public static void main(String[] args) {

		Employee e1 = new Employee();

		e1.setId(100);
		System.out.println(e1);

		Employee e2 = null;

		e2.setId(200);

		System.out.println(e2);
	}

}
