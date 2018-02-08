package com.annotationtasks.exceptions;

/**
 * This Exception is thrown when Pancard details are
 * either empty or contains null values
 * @author hemanth kumar
 *
 */
public class InvalidPanCardDetailsException extends RuntimeException {
	
	private static final long serialVersionUID = -1563037060865623887L;
	
	public InvalidPanCardDetailsException(String message) {
		super(message);
	}

}
