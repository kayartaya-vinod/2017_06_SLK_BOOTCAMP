package slk.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import slk.cfg.AppConfig1;
import slk.service.HelloService;

public class P02_SpringUsingAnnotationConfig {

	public static void main(String[] args) {
		
		ApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
		
		String beanName = "khs";
		
		System.out.println("----");
		HelloService service = ctx.getBean(beanName, HelloService.class);
		service.sayHello("Vinod");
		service = ctx.getBean(beanName, HelloService.class);
		service = ctx.getBean(beanName, HelloService.class);
		service = ctx.getBean(beanName, HelloService.class);
		service = ctx.getBean(beanName, HelloService.class);
		service = ctx.getBean(beanName, HelloService.class);
		
		((AbstractApplicationContext) ctx).close();
		
	}
}
