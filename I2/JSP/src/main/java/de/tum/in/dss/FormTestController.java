package de.tum.in.dss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FormTestController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		FormCommand formCommand = (FormCommand) command;
		System.out.println("Input: " + formCommand.getInput());

		// Forward to the success view
		return super.onSubmit(request, response, command, errors);
	}

}
