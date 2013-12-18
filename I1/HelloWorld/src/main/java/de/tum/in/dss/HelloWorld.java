package de.tum.in.dss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		for (int i = 0; i < 10; i++) {
			resp.getWriter().print("Hello World!");
			System.out.println("Hello World");
		}
	}

}
