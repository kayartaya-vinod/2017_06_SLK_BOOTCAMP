package slk.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import slk.dao.ContactsDao;
import slk.dao.DaoFactory;
import slk.entity.Contact;

@WebServlet("/save-contact")
public class SaveContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("add-new");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			String mode = request.getParameter("mode");

			Contact contact = new Contact();
			contact.setId(id);
			contact.setName(name);
			contact.setCity(city);
			contact.setEmail(email);
			contact.setPhone(phone);
			contact.setGender(gender);

			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			if (mode.equalsIgnoreCase("add")) {
				dao.createContact(contact);
			} else {
				dao.updateContact(contact);
			}
			String url = "view-contact?id=" + contact.getId();
			response.sendRedirect(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
