package de.ibis.tum;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NameValidator implements Validator {

	public boolean supports(Class clazz) {
		if (clazz.equals(NameCommand.class))
			return true;

		return false;
	}

	public void validate(Object obj, Errors err) {
		NameCommand cmd = (NameCommand) obj;

		int length = cmd.getInput().length();
		if (length < 3) {
			err.rejectValue("input", "too.short");
		}
	}
}
