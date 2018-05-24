package slk.entity;

public class Person extends Object {
	
	// data members (aka fields)
	private int id;
	private String name;
	private String email;
	private String phone;

	// adding a no-argument constructor (default constructor) is a good practice
	public Person() {
	}

	// parameterized / overloaded constructor
	public Person(int id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	// getter / accessor 
	public int getId() {
		return id;
	}

	// setter / mutator
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	public void print(){
		System.out.printf("Id             : %d\n", id);
		System.out.printf("Name           : %s\n", name);
		System.out.printf("Email          : %s\n", email);
		System.out.printf("Phone          : %s\n", phone);
	}

}

/*
 * The keyword "final" can be applied to a method, variable, or a class
 * For a method - Subclasses can not override this method
 * For a class - The class can not be used as a super class (no more inheritance)
 * For a variable (member/local) - The variable can be assigned a value only once
 */











