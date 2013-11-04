package de.ibis.tum;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ReverseController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();

		ReverseCommand cmd = (ReverseCommand) command;

		String reverse = new StringBuffer(cmd.getInput()).reverse().toString();

		model.put("input", cmd.getInput());
		model.put("result", reverse);

		return new ModelAndView("result", model);
	}
}
