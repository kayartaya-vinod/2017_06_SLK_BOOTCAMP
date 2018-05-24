package slk.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import slk.entity.Contact;

@WebServlet("/add-new")
public class AddNewContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = new Contact();
		request.setAttribute("contact", contact);
		request.setAttribute("title", "Add a new contact");
		request.setAttribute("mode", "add");

		request.getRequestDispatcher("/WEB-INF/jsp/contact-form.jsp").forward(request, response);

	}

}
