package slk.assignment;

public class Student extends Person {

	private double percentage;

	public Student() {
	}

	public Student(String name, double percentage) {
		super(name);
		this.percentage = percentage;
	}

	public void print() {
		System.out.printf("Name of student   : %s\n", getName());
		System.out.printf("Percentage marks  : %f\n", percentage);

	}

	@Override
	public boolean isOutstanding() {
		return percentage > 85;
	}

}
