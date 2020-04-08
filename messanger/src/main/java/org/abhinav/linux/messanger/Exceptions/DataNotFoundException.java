package org.abhinav.linux.messanger.Exceptions;

import java.io.Serializable;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DataNotFoundException() {
		super();
	}
	public DataNotFoundException(String msg) {
		super(msg);
	}
	public DataNotFoundException(String msg,Exception ex) {
		super(msg,ex);
	}
}
