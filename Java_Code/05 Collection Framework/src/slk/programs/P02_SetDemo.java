package slk.programs;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import slk.entity.Product;

public class P02_SetDemo {

	public static void main(String[] args) {

		Set<Integer> nums = new HashSet<Integer>();
		nums.add(55);
		nums.add(22);
		nums.add(33);
		nums.add(55);
		nums.add(22);
		nums.add(100);
		System.out.println(nums);

		Set<String> names = new HashSet<String>();
		names.add("Vinod");
		names.add("Vinay");
		names.add("Harish");
		names.add("Ramesh");
		names.add("Vinay");
		names.add("John");
		names.add("Jane");
		names.add("Arun");
		System.out.println(names);

		Set<Product> products = new TreeSet<Product>();

		products.add(new Product(1, "Mobile Phone", 12300));
		products.add(new Product(-5, "Mobile Phone", 12300));
		products.add(new Product(3, "Optical Mouse", 980));
		products.add(new Product(1, "Mobile Phone", 12300));
		products.add(new Product(4, "Laser Printer", 11500));
		products.add(new Product(1, "Mobile Phone", 12300));
		products.add(new Product(2, "Laptop", 22500));
		products.add(new Product(2, "Laptop", 22500));
		products.add(new Product(3, "Optical Mouse", 980));

		for(Product p: products){
			System.out.println(p);
		}
	}
}













