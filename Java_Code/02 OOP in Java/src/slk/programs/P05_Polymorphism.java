package slk.programs;

import slk.entity.Animal;
import slk.entity.Cat;
import slk.entity.Dog;
import slk.entity.Tiger;

public class P05_Polymorphism {
	public static void main(String[] args) {
		
		Animal a1;
		
		// a1 = new Animal(); // error; Animal is abstract; cannot instantiate
		
		a1 = new Tiger(); // Tiger IS-A Animal; an instanceof Tiger is also an instanceof Animal
		a1.talk();
		
		a1 = new Cat();
		a1.talk();
		
		a1 = new Dog();
		a1.talk();
		
		/*
		 * Line numbers 16, 19, 22 (a1.talk()) are identical to the compiler.
		 * The compiler does not associate (bind) the method call to any 
		 * method definition (which is exactly what happens in C++).
		 * The compiler simply checks if the method "talk" is present in the 
		 * type Animal, of which "a1" is a reference.
		 * 
		 * The statement a1.talk() is bound to a method definition only at the 
		 * runtime. The runtime, instead of picking the method definition 
		 * from the reference's type, picks the method definition from the
		 * instannce's type.
		 * 
		 * For example, in line 16, the instance's type is Cat. Hence the call
		 * is bound to the Cat.talk() function. And in the line 19, it is bound
		 * to the Tiger.talk()
		 * 
		 * Java does not support early binding.
		 */
	}
}
