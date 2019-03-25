package com;


import java.util.ArrayList;
import java.util.List;

public class Doctor {
	private String regNo;
	private String docName;
	
	List<Patient> patientList;
	public Doctor(String a,String b)
	{
		regNo=a;
		docName=b;
		patientList=new ArrayList<Patient>();
	}
	public Doctor()
	{
		patientList=new ArrayList<Patient>();
	}
	public String getRegNo()
	{
		return regNo;
	}
	public void setRegNo(String a)
	{
		regNo=a;
	}
	public String getDocName()
	{
		return docName;
	}
	public void setDocName(String s)
	{
		docName=s;
	}
	public List<Patient> getPatientList()
	{
		return patientList;
	}
	public void setPatientList(List<Patient> patientList)
	{
		this.patientList=patientList;
	}
	public int addPatient(Patient pa)
	{
		patientList.add(pa);
		return patientList.size();
	}
	public int releasePatient(Patient pa)
	{
		patientList.remove(pa);
		return patientList.size();
	}
	
}
