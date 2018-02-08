package com.annotationtasks.exceptions;

/**
 * This Exception is thrown when documents do not have 
 * consistent values
 * @author hemant kumar
 *
 */
public class IdentityDocumentConsistencyException  extends RuntimeException {
	
	private static final long serialVersionUID = 4763456084458579446L;
	
	public IdentityDocumentConsistencyException(String message) {
		super(message);
	}

}
