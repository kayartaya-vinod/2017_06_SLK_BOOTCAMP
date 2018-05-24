package slk.entity;

public class Employee extends Person {
	private double salary;
	private String department;

	public Employee() {
		super(); // implicitly done
	}

	public Employee(int id, String name, String email, String phone, double salary, String department) {
		super(id, name, email, phone);
		this.salary = salary;
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", department=" + department + ", Inherited=" + super.toString() + "]";
	}

	@Override
	public void print() {
		super.print();
		System.out.printf("Salary         : %.2f\n", salary);
		System.out.printf("Department     : %s\n", department);
		System.out.println();
	}
}
