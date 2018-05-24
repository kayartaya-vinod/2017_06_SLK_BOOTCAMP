package slk.entity;

public class Cat extends Animal{

	@Override
	public void talk() {
		// this method hides the visibility of the inherited abstract method "talk"
		System.out.println("Meow....");
	}

}
