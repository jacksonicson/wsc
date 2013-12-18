package de.tum.in.dss;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FormValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return (clazz.equals(FormCommand.class));
	}

	@Override
	public void validate(Object target, Errors errors) {
		FormCommand formCommand = (FormCommand) target;

		int length = formCommand.getInput().length();

		if (length > 4)
			errors.rejectValue("input", "too.long");
	}
}
