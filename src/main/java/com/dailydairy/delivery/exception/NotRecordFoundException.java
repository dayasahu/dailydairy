package com.dailydairy.delivery.exception;

public class NotRecordFoundException extends RuntimeException{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotRecordFoundException(Long id) {

	        super(String.format("Record with Id %d not found", id));
	    }
}
