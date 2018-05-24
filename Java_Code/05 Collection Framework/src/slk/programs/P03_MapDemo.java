package slk.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class P03_MapDemo {

	public static void main(String[] args) {
		
		// important methods in a Map are:
		// put, get, containsKey, containsValue, clear, remove, values, keySet
		
		Map<String, String> map1 = new LinkedHashMap<>();
		map1.put("vinod", "Bangalore");
		map1.put("john doe", "Dallas");
		map1.put("jane doe", "Dallas");
		map1.put("vinod", "Mangalore");
		map1.put("vinod", "Shimoga");
		map1.put("Vinod", "Mumbai");
		map1.put("arun", "Mumbai");
		map1.put("naveen", "Mumbai");
		
		System.out.println(map1.keySet());
		System.out.println(map1.values());
		
		// loop thru the entire map
		for(String key: map1.keySet()){
			String val = map1.get(key);
			System.out.printf("%s --> %s\n", key, val);
		}
		
		
		
	}
}
