package slk.service;

public class KannadaHelloService implements HelloService {

	public KannadaHelloService() {
		System.out.println("from inside KannadaHelloService() constructor");

	}

	@Override
	public void sayHello(String name) {
		System.out.printf("ಹಲೋ, %s!\n", name);
	}

}
