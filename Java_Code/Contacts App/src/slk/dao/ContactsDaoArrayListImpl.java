package slk.dao;

import java.util.ArrayList;
import java.util.List;

import slk.entity.Contact;

public class ContactsDaoArrayListImpl implements ContactsDao {

	List<Contact> contacts;

	public ContactsDaoArrayListImpl() {
		contacts = new ArrayList<>();
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		contacts.add(contact);
	}

	@Override
	public Contact getCotnact(int id) throws DaoException {
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {

	}

	@Override
	public void deleteContact(int id) throws DaoException {

	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		return contacts;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		return null;
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		return null;
	}

}
