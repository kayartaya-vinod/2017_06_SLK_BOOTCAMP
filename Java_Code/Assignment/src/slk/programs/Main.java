package slk.programs;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import slk.entity.Product;
import slk.util.KeyboardUtil;

public class Main {

	public static void main(String[] args) {
		
		
		Map<String, Set<Product>> map;
		map = new TreeMap<>();
		
		while(true){
			String category = KeyboardUtil.getString("Enter category: ");
			String name = KeyboardUtil.getString("Enter name: ");
			double price = KeyboardUtil.getDouble("Enter price: ");
			
			addProductToMap(map, category, name, price);
			
			report(map);
			
			String choice = KeyboardUtil.getString("Type 'no' stop, or press enter to continue: ");
			if(choice.equalsIgnoreCase("no")){
				break;
			}
		}
		
		System.out.println("Thanks for using the app!");
	}

	public static void addProductToMap(Map<String, Set<Product>> map, String category, String name, double price) {
		Product p = new Product(name, price);
		Set<Product> products;
		
		if(map.containsKey(category)){
			products = map.get(category);
		}
		else {
			products = new TreeSet<>((p1, p2)->Double.compare(p2.getPrice(), p1.getPrice()));
			map.put(category, products);
		}
		products.add(p);
	}

	public static void report(Map<String, Set<Product>> map) {
		for(String category: map.keySet()){
			System.out.println(category);
			Set<Product> products = map.get(category);
			for(Product p: products){
				System.out.printf("\t%s @ %.2f\n", p.getName(), p.getPrice());
			}
		}
		System.out.println("---------------------------------");
	}
}
