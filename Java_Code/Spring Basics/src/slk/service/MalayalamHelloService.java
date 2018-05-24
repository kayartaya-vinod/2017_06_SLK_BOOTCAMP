package slk.service;

public class MalayalamHelloService implements HelloService {
	public MalayalamHelloService() {
		System.out.println("from inside MalayalamHelloService() constructor");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("ഹലോ, %s!\n", name);
	}

}
