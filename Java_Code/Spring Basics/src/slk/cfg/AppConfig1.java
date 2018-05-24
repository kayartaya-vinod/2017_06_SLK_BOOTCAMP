package slk.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import slk.service.EnglishHelloService;
import slk.service.FrenchHelloService;
import slk.service.KannadaHelloService;
import slk.service.MalayalamHelloService;

// this class definition is equivalent to (replacement for) context01.xml
// the whole class represents <beans...></beans> in the context01.xml
@Configuration
public class AppConfig1 {

	public AppConfig1() {
		System.out.println("From inside the AppConfig1() constructor!");
	}

	// this function is equivalent to <bean..></bean>
	// by default the name of the bean is same the name of the function
	// by default the scope of the bean is singleton
	@Bean
	public EnglishHelloService ehs() {
		return new EnglishHelloService();
	}

	@Bean(name = "fhs")
	@Scope("prototype")
	public FrenchHelloService french() {
		return new FrenchHelloService();
	}
	
	@Bean
	public KannadaHelloService khs(){
		return new KannadaHelloService();
	}
	
	@Bean
	public MalayalamHelloService mhs(){
		return new MalayalamHelloService();
	}
}






