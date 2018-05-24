package slk.entity;

public abstract class Shape {
	/*
	 * static variables will not be part of object's memory.
	 * It will be part of the class definition, to be accessed using the
	 * name of the class (like Shape.PI), and will occupy memory in the
	 * permanent generation (perm-gen). Effectively, even if there 
	 * are hundreds or thousands of Shape objects (using Circle/Triangle),
	 * there will be only one copy of PI in the memory.
	 */
	public static final double PI = 3.1415;

	public abstract double getArea();
	
	public abstract String toString();
}
