package slk.entity;

import slk.util.StringUtils;

public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee() {
	}

	public Employee(int id, String name, double salary) throws InvalidNameException, InvalidSalaryException {
		setId(id);
		setName(name);
		setSalary(salary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {
		if (name == null) {
			throw new InvalidNameException("Name cannot be null");
		}
		if (name.trim().length() == 0) {
			throw new InvalidNameException("Name cannot be blank");
		}
		if (name.trim().length() > 25) {
			throw new InvalidNameException("Name should be a max of 25 letters");
		}

		if (StringUtils.containsDigit(name)) {
			throw new InvalidNameException("Name cannot contain a digit");
		}

		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws InvalidSalaryException {
		if (salary < 15000 || salary > 500000) {
			throw new InvalidSalaryException("Salary not in valid range 15000 - 500000");
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
