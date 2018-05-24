package slk.assignment;

public class Professor extends Person {

	private int booksPublished;

	public Professor() {
	}

	public Professor(String name, int booksPublished) {
		super(name);
		this.booksPublished = booksPublished;
	}

	public void display() {
		System.out.printf("Name              : Prof.%s\n", getName());
		System.out.printf("Books published   : %d\n", booksPublished);
	}

	@Override
	public boolean isOutstanding() {
		return booksPublished > 4;
	}

}
