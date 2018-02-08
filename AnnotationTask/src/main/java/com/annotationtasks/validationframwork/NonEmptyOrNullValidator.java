package com.annotationtasks.validationframwork;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This is validator, which validates for empty or null values
 * 
 * @author hemant kumar
 *
 */
public class NonEmptyOrNullValidator implements ConstraintValidator<NotEmptyNotNull, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		} else if (value.equals("")) {
			return false;
		}

		return true;
	}

}
