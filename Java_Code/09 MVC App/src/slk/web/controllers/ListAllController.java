package slk.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.dao.DaoFactory;
import slk.entity.Contact;

@WebServlet("/list-all")
public class ListAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. read all inputs from the request
		// NOT APPLICABLE FOR THIS USECASE
		
		// 2. invoke the model
		try {
			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			List<Contact> list = dao.getAllContacts();
			
			// 3. store the model data in a scope
			request.setAttribute("contacts", list);
			
			// 4. forward to a view
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/show-contacts.jsp");
			rd.forward(request, response);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
