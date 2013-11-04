package de.ibis.tum;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ReverseValidator implements Validator {

	public boolean supports(Class clazz) {
		if (clazz.equals(ReverseCommand.class))
			return true;

		return false;
	}

	public void validate(Object obj, Errors err) {
		ReverseCommand cmd = (ReverseCommand) obj;

		int length = cmd.getInput().length();
		if (length < 3) {
			err.rejectValue("input", "too.short");
		}
		if (length > 10) {
			err.rejectValue("input", "too.long");
		}
	}
}
