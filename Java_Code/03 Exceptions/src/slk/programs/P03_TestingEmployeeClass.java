package slk.programs;

import slk.entity.Employee;

public class P03_TestingEmployeeClass {
	
	
	public static void main(String[] args) throws Exception {
		
		Employee e1;
		
		e1 = new Employee();
		
		e1.setId(1122);
		e1.setName("DonIV");
		e1.setSalary(25000);
		
		System.out.println(e1);
		
	}
}
