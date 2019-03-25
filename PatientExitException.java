package com;

public class PatientExitException extends Exception {
	
	long serialVersionID;
	PatientExitException()
	{
		super();
	}
	
	@Override
	public String getMessage()
	{
		return "Patient is exit";
	}

}
