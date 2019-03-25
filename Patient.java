package com;

public class Patient {
	private String uld;
	private int patientID;
	private String patientName;
	private String city;
	public Patient(String uld,String patientName,String city)
	{
		this.uld=uld;
		this.patientName=patientName;
		this.city=city;
	}
	public int getPatientID()
	{
		return patientID;
	}
	public void setPatientID(int id)
	{
		patientID=id;
	}
	public String getPatientName()
	{
		return patientName;
	}
	public void setPatientName(String name)
	{
		patientName=name;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getCity()
	{
		return city;
	}
	public String getUld()
	{
		return uld;
	}
	public void setUld(String uld)
	{
		this.uld=uld;
	}
}
