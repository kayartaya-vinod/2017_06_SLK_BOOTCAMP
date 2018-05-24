package slk.programs;

import slk.entity.Product;

public class P01_ObjectCreation {

	public static void main(String[] args) {
		Product p1;
		p1 = new Product();
		
		p1.id = 101;
		p1.price = 45000;
		p1.name = "Lenovo Z560";
		
		Product p2 = p1;
		
		p1 = null;
		p2 = null;
		
		System.out.println("p1 is " + p1);
	}
}
