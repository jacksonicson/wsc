package de.ibis.tum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	private TestModel model;

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("Test Message");

		// Invoke model
		model.logic();

		return new ModelAndView("test", "model", model);
	}

	public void setModel(TestModel model) {
		this.model = model;
	}

}
