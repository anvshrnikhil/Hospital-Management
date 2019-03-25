package com;

public class DuplicateDoctorException extends Exception {
	
	long serialVersionULD;
	public DuplicateDoctorException()
	{
		super();
	}
	@Override
	public String getMessage()
	{
		return "Duplicate Doctor";
	}

}
