package slk.dao;

import java.util.List;

import slk.entity.Contact;

public interface ContactsDao {

	// CRUD OPERATIONS
	public void createContact(Contact contact) throws DaoException;

	public Contact getCotnact(int id) throws DaoException;

	public void updateContact(Contact contact) throws DaoException;

	public void deleteContact(int id) throws DaoException;

	// QUERIES

	public List<Contact> getAllContacts() throws DaoException;

	public List<Contact> getContactsByCity(String city) throws DaoException;
	
	public List<Contact> search(String token) throws DaoException;
}



