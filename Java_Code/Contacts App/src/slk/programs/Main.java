package slk.programs;

import java.util.List;

import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.dao.DaoFactory;
import slk.entity.Contact;
import slk.util.KeyboardUtil;

// the application
public class Main {

	ContactsDao dao;

	public Main() {
		try {
			dao = DaoFactory.getContactsDao("jdbc");
		} catch (DaoException e) {
			System.out.println("Couldn't create dao object! Cannot continue.");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.init();

		m.start();
	}

	void init() {
		try {
			Contact c = new Contact();
			c.setId(1);
			c.setName("Vinod Kumar");
			c.setPhone("9731424784");
			c.setEmail("vinod@vinod.co");
			c.setCity("Bangalore");
			c.setGender("Male");
			dao.createContact(c);

			c = new Contact();
			c.setId(2);
			c.setName("John Doe");
			c.setPhone("5558902233");
			c.setEmail("johndoe@mailinator.com");
			c.setCity("Dallas");
			c.setGender("Male");
			dao.createContact(c);

			c = new Contact();
			c.setId(3);
			c.setName("Jane Doe");
			c.setPhone("5552823344");
			c.setEmail("janedoe@mailinator.com");
			c.setCity("Chicago");
			c.setGender("Female");
			dao.createContact(c);
		} catch (DaoException e) {
			System.out.println("There was a problem!");
			System.out.println(e.getMessage());
		}
	}

	public void start() {
		int choice;

		while ((choice = menu()) != 7) {
			switch (choice) {
			case 1:
				handleCreateContact();
				break;
			case 2:
				handleGetContact();
				break;
			case 3:
				handleDeleteContact();
				break;
			case 4:
				handleUpdateContact();
				break;
			case 5:
				handleShowAll();
				break;
			case 6:
				handleSearchByCity();
				break;
			default:
				System.out.println("Invalid choice. Please select from 1 to 7.");
			}
		}
		System.out.println("Thanks for using the app. Have a nice day!");
	}

	public void handleCreateContact() {
		System.out.println("Creating a new contact.");
		int id = KeyboardUtil.getInt("Enter id: ");
		String name = KeyboardUtil.getString("Enter name: ");
		String email = KeyboardUtil.getString("Enter email: ");
		String phone = KeyboardUtil.getString("Enter phone: ");
		String city = KeyboardUtil.getString("Enter city: ");
		String gender = KeyboardUtil.getString("Enter gender: ");

		Contact c = new Contact();
		c.setId(id);
		c.setName(name);
		c.setPhone(phone);
		c.setEmail(email);
		c.setCity(city);
		c.setGender(gender);

		try {
			dao.createContact(c);
		} catch (DaoException e) {
			System.out.println("There was an error while creating a contact.");
			System.out.println(e.getMessage());
		}

	}

	public void handleGetContact() {
		int id = KeyboardUtil.getInt("Enter the id: ");
		try {
			Contact c = dao.getCotnact(id);

			if (c == null) {
				System.out.println("No data found for id " + id);
			} else {
				System.out.printf("----------- Data for id %d -----------\n", id);
				System.out.printf("Name       : %s%s\n", (c.getGender().equals("Male") ? "Mr." : "Ms."), c.getName());
				System.out.printf("Email      : %s\n", c.getEmail());
				System.out.printf("Phone      : %s\n", c.getPhone());
				System.out.printf("City       : %s\n", c.getCity());
				System.out.println();
			}

		} catch (DaoException e) {
			System.out.println("There was a problem!");
			System.out.println(e.getMessage());
		}
	}

	public void handleDeleteContact() {
		int id = KeyboardUtil.getInt("Enter the id: ");
		try {
			dao.deleteContact(id);
			System.out.println("Deleted the contact with id " + id);
		} catch (DaoException e) {
			System.out.println("There was a problem!");
			System.out.println(e.getMessage());
		}
	}

	public void handleUpdateContact() {
		int id = KeyboardUtil.getInt("Enter the id: ");
		try {
			Contact c = dao.getCotnact(id);

			String name = KeyboardUtil.getString("Enter name (" + c.getName() + "): ");
			if (name.trim().length() != 0) {
				c.setName(name);
			}
			String email = KeyboardUtil.getString("Enter email (" + c.getEmail() + "): ");
			if (email.trim().length() != 0) {
				c.setEmail(email);
			}
			String phone = KeyboardUtil.getString("Enter phone (" + c.getPhone() + "): ");
			if (phone.trim().length() != 0) {
				c.setPhone(phone);
			}
			String city = KeyboardUtil.getString("Enter city (" + c.getCity() + "): ");
			if (city.trim().length() != 0) {
				c.setCity(city);
			}
			String gender = KeyboardUtil.getString("Enter gender (" + c.getGender() + "): ");
			if (gender.trim().length() != 0) {
				c.setGender(gender);
			}
			dao.updateContact(c);

		} catch (DaoException e) {
			System.out.println("There was a problem!");
			System.out.println(e.getMessage());
		}
	}

	public void handleShowAll() {

		try {
			List<Contact> list = dao.getAllContacts();
			if (list == null) {
				return;
			}
			report(list);
		} catch (DaoException e) {
			System.out.println("There is a problem!");
			System.out.println(e.getMessage());
		}
	}

	private void report(List<Contact> list) {
		line("=", 80);
		System.out.printf("%-5s %-6s %-15s %-25s %-10s %-15s\n", "Id", "Gender", "Name", "Email", "Phone", "City");
		line("=", 80);
		for (Contact c : list) {
			System.out.printf("%-5s %-6s %-15s %-25s %-10s %-15s\n", c.getId(), c.getGender(), c.getName(),
					c.getEmail(), c.getPhone(), c.getCity());
		}
		line("-", 80);
	}

	private void line(String pattern, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(pattern);
		}
		System.out.println();
	}

	public void handleSearchByCity() {
		String city = KeyboardUtil.getString("Enter the city: ");
		try {
			List<Contact> list = dao.getContactsByCity(city);
			report(list);
		} catch (DaoException e) {
			System.out.println("There was a problem!");
			System.out.println(e.getMessage());
		}
	}

	public int menu() {
		while (true) {
			System.out.println("*** Main Menu ***");
			System.out.println("1. Add new contact");
			System.out.println("2. Search and display contact by id");
			System.out.println("3. Delete contact");
			System.out.println("4. Search and update contact details");
			System.out.println("5. Show all contacts");
			System.out.println("6. Show contacts from given city");
			System.out.println("7. Exit");
			String choice = KeyboardUtil.getString("Enter your choice: ");
			try {
				int ch = Integer.parseInt(choice);
				return ch;
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry for choice. Retry!");
			}
			System.out.println();

		}
	}
}
