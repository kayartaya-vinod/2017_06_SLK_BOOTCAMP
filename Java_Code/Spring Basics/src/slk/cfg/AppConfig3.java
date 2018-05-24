package slk.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import slk.dao.ContactsDao;
import slk.dao.ContactsDaoSpringImpl;

@Configuration
public class AppConfig3 {

	@Bean(name = { "dbcp", "dataSource", "ds" })
	public DataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.hsqldb.jdbcDriver");
		bds.setUrl("jdbc:hsqldb:hsql://localhost/training");
		// for HSQL, username/password defaults to "sa" and ""
		return bds;
	}

	// the above bean ("dataSource") will be wired with the below given bean ("template")
	@Bean(autowire = Autowire.BY_NAME)
	public JdbcTemplate template() {
		return new JdbcTemplate();
	}

	@Bean
	public ContactsDao dao() {
		return new ContactsDaoSpringImpl();
	}

}
