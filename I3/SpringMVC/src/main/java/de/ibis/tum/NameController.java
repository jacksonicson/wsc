package de.ibis.tum;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class NameController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(Object command, BindException errors)
			throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();

		NameCommand cmd = (NameCommand) command;

		String result = cmd.getInput().toUpperCase();

		model.put("input", cmd.getInput());
		model.put("result", result);

		return new ModelAndView("result", model);
	}
}
