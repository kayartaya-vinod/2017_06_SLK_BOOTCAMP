package slk.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import slk.dao.ContactsDao;
import slk.dao.DaoException;
import slk.dao.DaoFactory;
import slk.entity.Contact;


@WebServlet("/search")
public class SearchContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. read the inputs from request
		// typically handled by Servlets
		String token = request.getParameter("token");
		
		// 2. process the inputs
		// typically handled by service/DAO tiers
		List<Contact> list;
		try {
			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			list = dao.search(token);
			
			// 3. generate the response
			// typically handled by JSPs
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Search result for the token '" + token + "' </h1>");
			out.println("<hr>");
			if(list.size()==0){
				out.println("<h3 style='color: red'>No data found!</h3>");
			}
			else {
				out.println("<ul>");
				for(Contact c: list){
					String li = String.format("<li>%s%s (%s, %s) - %s</li>",
							c.getGender().equalsIgnoreCase("male")?"Mr.":"Ms.", 
							c.getName(), c.getEmail(), c.getPhone(), c.getCity());
					out.println(li);
				}
				out.println("</ul>");
			}
			out.close();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		
	}

}






