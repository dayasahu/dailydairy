package com.dailydairy.delivery.exception;

public class CustomerNotFoundException extends RuntimeException{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CustomerNotFoundException(Long id) {

	        super(String.format("Customer with Id %d not found", id));
	    }
}
