package slk.service;

public class FrenchHelloService implements HelloService {

	public FrenchHelloService() {
		System.out.println("from inside FrenchHelloService() constructor");
	}
	@Override
	public void sayHello(String name) {
		System.out.printf("Bonjour, %s!\n", name);
	}

}
