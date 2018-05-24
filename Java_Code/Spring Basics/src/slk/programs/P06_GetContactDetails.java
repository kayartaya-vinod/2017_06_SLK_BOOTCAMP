package slk.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import slk.cfg.AppConfig3;
import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.entity.Contact;

public class P06_GetContactDetails {

	public static void main(String[] args) throws DaoException {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		
		ContactsDao dao = (ContactsDao) ctx.getBean("dao");

		System.out.println("----------------- contact by id 1:");
		Contact c1 = dao.getContact(1);
		System.out.println(c1);
		System.out.println("----------------- all contacts:");
		
		List<Contact> list = dao.getAllContacts();
		for(Contact c: list){
			System.out.println(c.getName() + " --> " + c.getCity());
		}
		System.out.println("----------------- contacts by city:");
		
		list = dao.getContactsByCity("lore");
		for(Contact c: list){
			System.out.println(c.getName() + " --> " + c.getCity());
		}
		System.out.println("----------------- search for token 'ar'");
		
		list = dao.search("ar");
		for(Contact c: list){
			System.out.println(c.getName() + " --> " + c.getCity());
		}
		System.out.println("-----------------");

		ctx.close();
		
	}
}
