package de.tum.in.dss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SubmitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("form.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Read input data
		String name = req.getParameter("name");
		if (name == null) {
			System.out.println("Did not recieve an input parameter");
		} else {
			System.out.println("Name: " + name);
		}

		resp.setContentType("text/plain");
		resp.getWriter().print("Name: " + name);

	}

}
