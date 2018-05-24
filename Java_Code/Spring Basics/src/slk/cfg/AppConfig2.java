package slk.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import slk.dao.ContactsDaoSpringImpl;

@Configuration
public class AppConfig2 {

	@Bean
	public ContactsDaoSpringImpl dao(){
		ContactsDaoSpringImpl varDao = new ContactsDaoSpringImpl();
//		varDao.setDriverClassName("org.hsqldb.jdbcDriver");
//		varDao.setUrl("jdbc:hsqldb:hsql://localhost/training");
//		varDao.setUsername("sa");
//		varDao.setPassword("");
		
		return varDao;
	}
}
