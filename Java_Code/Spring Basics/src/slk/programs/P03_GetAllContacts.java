package slk.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import slk.cfg.AppConfig3;
import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.entity.Contact;

public class P03_GetAllContacts {

	public static void main(String[] args) throws DaoException {

		// ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context2.xml");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

		ContactsDao dao = ctx.getBean("dao", ContactsDao.class);

		for (Contact c : dao.getAllContacts()) {
			System.out.println(c.getName() + " lives in " + c.getCity());
		}

		ctx.close();
	}
}
