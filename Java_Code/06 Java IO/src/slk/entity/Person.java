package slk.entity;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int counter = 1;

	private int id;
	private String name;
	private double height;

	public Person() {
		this.id = counter++;
	}

	public Person(String name, double height) {
		this(); // call to another constructor in the same class
		this.name = name;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public void print() {
		System.out.printf("Id      : %s\n", id);
		System.out.printf("Name    : %s\n", name);
		System.out.printf("Height  : %.2f ft\n", height);
	}
}
