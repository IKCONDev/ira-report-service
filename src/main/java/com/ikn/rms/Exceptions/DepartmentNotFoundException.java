package com.ikn.rms.Exceptions;

public class DepartmentNotFoundException   extends RuntimeException {

	
	public DepartmentNotFoundException(String message) {
        super(message);
    }
}