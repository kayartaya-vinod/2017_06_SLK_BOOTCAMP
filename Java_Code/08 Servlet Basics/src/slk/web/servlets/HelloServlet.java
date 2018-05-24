package slk.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("username");
		String place = req.getParameter("city");
		
		System.out.println("From inside of HelloServlet.doGet() method!");
		
		// set the content type before obtaining the output stream
		resp.setContentType("text/html");
		
		// "resp" --> "paper", "resp.getWriter()" --> "pen"
		PrintWriter out = resp.getWriter();
		out.printf("<h1>Hello, %s! How's weather in %s?</h1>", name, place);
		out.close();
		

	}

}
