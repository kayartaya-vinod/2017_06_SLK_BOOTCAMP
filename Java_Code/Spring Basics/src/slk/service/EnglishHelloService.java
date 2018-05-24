package slk.service;

public class EnglishHelloService implements HelloService {
	
	public EnglishHelloService() {
		System.out.println("from inside EnglishHelloService() constructor");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("Hello, %s!\n", name);
	}

}
