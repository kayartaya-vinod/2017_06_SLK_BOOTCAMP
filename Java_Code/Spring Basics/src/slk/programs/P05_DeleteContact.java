package slk.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import slk.cfg.AppConfig3;
import slk.dao.ContactsDao;
import slk.dao.DaoException;

public class P05_DeleteContact {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		
		ContactsDao dao = (ContactsDao) ctx.getBean("dao");
		try {
			dao.deleteContact(789);
			System.out.println("Delete succeeded!");
		} catch (DaoException e) {
			System.err.println(e.getMessage());
		}
		
		ctx.close();
	}
}
