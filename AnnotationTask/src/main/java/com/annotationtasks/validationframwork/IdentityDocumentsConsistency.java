package com.annotationtasks.validationframwork;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom Annotation for documents consistency
 * To be Used on IdentityDocumentsValidator.class
 * @author hemanth kumar
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = IdentityDocumentsValidator.class)
public @interface IdentityDocumentsConsistency {
	
	String message() default "values do not match in all documents provided";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
