package com.annotationtasks.validationframwork;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom Annotation, used to validate empty or null values for string field
 * 
 * @author hemanth kumar
 *
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = NonEmptyOrNullValidator.class)
public @interface NotEmptyNotNull {
	String message() default "value should not be empty or null";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
