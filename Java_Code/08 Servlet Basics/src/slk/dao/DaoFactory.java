package slk.dao;

public final class DaoFactory {
	private DaoFactory() {
	}

	public static ContactsDao getContactsDao(String type) throws DaoException {
		switch (type.toLowerCase()) {
		case "array":
			// return an array based implementation of ContactsDao
		case "arraylist":
			// return a ArrayList based implementation of ContactsDao
		case "file":
			// return a file based implementation of ContactsDao
		case "jdbc":
			return new ContactsDaoJdbcImpl();
		default:
			throw new DaoException("Unknown type for ContactsDao implementation!");
		}

	}
}
