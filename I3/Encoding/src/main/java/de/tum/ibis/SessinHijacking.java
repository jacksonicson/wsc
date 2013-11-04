package de.tum.ibis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

public class SessinHijacking extends HttpServlet {

	private static final long serialVersionUID = -2718559895410525429L;
	
	private Logger log = Logger.getLogger(SessinHijacking.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {

		// Only required if the servlet filter is not used
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession();
		List<String> messages = (List<String>) session.getAttribute("messages");

		PrintWriter writer = resp.getWriter();
		writer.print("<html><body>");

		for (String message : messages) {
			log.info("Message: " + message);
			message = StringEscapeUtils.escapeHtml(message);
			System.out.println("Escaped message: " + message);
			writer.print("<p>" + message + "</p>");
		}

		writer.print("<a href='form.jsp'>Add Item</a>");

		writer.print("</body></html>");

		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Character encoding: " + req.getCharacterEncoding());
		System.out.println("Content Type: " + req.getContentType());

		HttpSession session = req.getSession();

		List<String> messages = (List<String>) session.getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
		}

		System.out.println("message: " + req.getParameter("message"));

		if (req.getParameter("message") != null) {
			String msg = req.getParameter("message");
			messages.add(msg);
			resp.sendRedirect("hijack");
			return;
		}

	}

}
