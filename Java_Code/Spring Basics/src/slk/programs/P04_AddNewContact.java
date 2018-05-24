package slk.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import slk.cfg.AppConfig3;
import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.entity.Contact;

public class P04_AddNewContact {

	public static void main(String[] args) throws DaoException {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		
		ContactsDao dao = (ContactsDao) ctx.getBean("dao");
		Contact contact = new Contact();
		contact.setId(10);
		contact.setName("Amit Varma");
		contact.setEmail("amitvarma@mail.com");
		contact.setCity("Nagpur");
		contact.setPhone("88827262622");
		contact.setGender("Male");
		
		dao.createContact(contact);
		System.out.println("Done adding!");
		
		ctx.close();
	}
}
