package slk.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import slk.service.HelloService;

public class P01_SpringAsFactory {
	public static void main(String[] args) {
		
		// a variable representing spring-container
		ApplicationContext ctx;
		
		System.out.println("Creating a spring container...");
		// an object of spring-container, created using an XML file found in the classpath
		ctx = new ClassPathXmlApplicationContext("context01.xml");
		System.out.println("Creating a spring container is over!!");
		
		// get the service instance using spring (as factory method)
		HelloService service = ctx.getBean("mhs", HelloService.class);
		HelloService mhs = ctx.getBean("mhs", HelloService.class);
		
		System.out.println("service==mhs is " + (service==mhs));
		
		// use the service
		service.sayHello("Vinod");
		
		((AbstractApplicationContext) ctx).close();
		
	}
}
