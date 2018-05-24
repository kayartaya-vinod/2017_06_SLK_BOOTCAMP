package slk.programs;

import slk.entity.Circle;
import slk.entity.Shape;
import slk.entity.Triangle;

public class P06_Polymorphism {

	public static void printArea(Shape s) {
		System.out.printf("The are of %s is %f\n", s, s.getArea());
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle(12.34);
		Triangle t1 = new Triangle(11.22, 33.44);
		
		printArea(c1);
		printArea(t1);
		
	}

}
