package com.annotationtasks.exceptions;

/**
 * This Exception is thrown when Aadhar card 
 * details either empty or null
 * @author hemant kumar
 *
 */
public class InvalidAadharCardDetailsException extends RuntimeException {

	private static final long serialVersionUID = -1563037060865623087L;

	public InvalidAadharCardDetailsException(String message) {
		super(message);
	}
}
