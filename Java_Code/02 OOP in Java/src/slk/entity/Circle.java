package slk.entity;

public class Circle extends Shape {

	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle";
	}

}
