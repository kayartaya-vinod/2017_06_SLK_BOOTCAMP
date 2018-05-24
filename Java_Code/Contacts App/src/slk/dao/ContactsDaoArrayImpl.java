package slk.dao;

import java.util.List;

import slk.entity.Contact;

public class ContactsDaoArrayImpl implements ContactsDao {

	private Contact[] contacts = new Contact[1000];
	private int index = 0;

	@Override
	public void createContact(Contact contact) throws DaoException {
		contacts[index++] = contact;
	}

	@Override
	public Contact getCotnact(int id) throws DaoException {
		for (int i = 0; i < index; i++) {
			Contact c = contacts[i];
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		boolean found = false;
		for (int i = 0; i < index; i++) {
			Contact c = contacts[i];
			if (c.getId() == contact.getId()) {
				found = true;
				contacts[i] = contact;
				break;
			}
		}
		if (!found) {
			throw new DaoException("No data found for the given contact!");
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		boolean found = false;
		for (int i = 0; i < index; i++) {
			Contact c = contacts[i];
			if (c.getId() == id) {
				contacts[i] = contacts[index - 1];
				contacts[index - 1] = null;
				index--;
				break;
			}
		}
		if (!found) {
			throw new DaoException("No data found for the given id!");
		}
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		throw new DaoException("Mehtod not implemented!");
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		throw new DaoException("Mehtod not implemented!");
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		throw new DaoException("Mehtod not implemented!");
	}

}


