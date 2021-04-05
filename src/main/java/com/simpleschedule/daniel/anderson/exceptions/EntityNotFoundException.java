package com.simpleschedule.daniel.anderson.exceptions;

public class EntityNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -391327096130132428L;

	public EntityNotFoundException(String message, Throwable error) {
		super(message, error);
	}
	
	public EntityNotFoundException(String message) {
		super(message);
	}
}
