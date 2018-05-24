package slk.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.dao.DaoFactory;
import slk.entity.Contact;

@WebServlet("/edit-contact")
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("id");
		if(input==null){
			// report an error
		}
		else {
			try {
				int id = Integer.parseInt(input);
				ContactsDao dao = DaoFactory.getContactsDao("jdbc");
				Contact contact = dao.getCotnact(id);
				
				request.setAttribute("contact", contact);
				request.setAttribute("title", "Edit contact for id " + id);
				request.setAttribute("mode", "edit");
				
				request.getRequestDispatcher("/WEB-INF/jsp/contact-form.jsp")
					.forward(request, response);
				
			} catch (NumberFormatException e) {
				// report an error
			} catch(DaoException e){
				// report an error
			}
		}
	}

}
