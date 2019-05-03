package com;

import java.util.Scanner;

public class HospitalExecution {
	
	
	private Scanner sc;

	public static void main(String args[])
	{
		new HospitalExecution().hospital();
	}
	
	private void hospital()
	{
		sc = new Scanner(System.in);
		//here we got doctors details
		Doctor doctor[] = getDoctorsData();
		//here we got patients details 
		IDGenerator idGen = new IDGenerator();
		Patient patient[] = generatePatientsData(idGen);
		
		doctor = getPatients(doctor,patient);
		
		
		HospitalMgmtImpl hospitalManagement = new HospitalMgmtImpl();
		
		for(int itr=0;itr<doctor.length;itr++)
		{
			hospitalManagement.registerDoctor(doctor[itr]);
		}
		  
		//City count
		System.out.println();
		System.out.println("=================================================");
		System.out.println("No.of patients from Cities");
		System.out.println("Enter City name:");
		String city_str =sc.next();
		
		System.out.println("\n"+city_str+" : "+hospitalManagement.patientCountPerCity(city_str));
		
		System.out.println("=================================================");
		//Doctor Info
		
		System.out.println();
		System.out.println("Show Doctor Info to a particular Patient");
		System.out.print("Patient id:");
		int pat_num = sc.nextInt();
		Doctor doc = hospitalManagement.retriveDoctorInfo(pat_num);
		System.out.println("Doctor info");
		System.out.println("Doctor Name:"+doc.getDocName());
		System.out.println("Doctor ID:"+doc.getRegNo());
		System.out.println("+++++++++++++++++++++++++++++++++++");
		//Release Patient
		
		
		System.out.println();
		System.out.println("Releasing patient using ID");
		System.out.print("Patient ID:");
		pat_num=sc.nextInt();
		System.out.println("Pateint info : "+patient[pat_num-1].getPatientName());
		hospitalManagement.releasePatient(pat_num);
		System.out.println("Patient is released from hospital");
	}
	
	private Doctor[] getPatients(Doctor[] doctor, Patient[] patient)
	{
		for(int itr=0;itr<patient.length;itr++)
		{
			System.out.println("Patient ID: "+patient[itr].getPatientID()+"  Patient Name: "+patient[itr].getPatientName());
			for(int inner_itr=0;inner_itr<doctor.length;inner_itr++)
			{
				System.out.println(inner_itr+" ) Doctor Name: "+doctor[inner_itr].getDocName()+" ID: "+doctor[inner_itr].getRegNo());
			}
			System.out.print("Select Doctor: ");
			int index = sc.nextInt();
			doctor[index].addPatient(patient[itr]);
		}
		System.out.println("Doctors are assigned to all patients");
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		return doctor;
	}
	
	
	
	private Patient[] generatePatientsData(IDGenerator idGen)
	{
		Patient patient[] = new Patient[5];
		for(int itr=0;itr<patient.length;itr++)
		{
			patient[itr] = new Patient();
		}
		
		patient[0].setPatientName("Nikhil");
		patient[0].setCity("Guntur");
		patient[0].setPatientID(idGen.getID());
		patient[0].setUld("abcd0");
		
		patient[1].setPatientName("Ravi");
		patient[1].setCity("Vizag");
		patient[1].setPatientID(idGen.getID());
		patient[1].setUld("abcd1");
		
		patient[2].setPatientName("Lalith");
		patient[2].setCity("Srikakulam");
		patient[2].setPatientID(idGen.getID());
		patient[2].setUld("abcd2");
		
		patient[3].setPatientName("Danush");
		patient[3].setCity("Vizag");
		patient[3].setPatientID(idGen.getID());
		patient[3].setUld("abcd3");
		
		patient[4].setPatientName("Pavan");
		patient[4].setCity("Vizag");
		patient[4].setPatientID(idGen.getID());
		patient[4].setUld("abcd4");
		
		
		return patient;
	}
	
	private Doctor[] getDoctorsData()
	{
		Doctor doctor[] = new Doctor[3];
		for(int itr=0;itr<doctor.length;itr++)
		{
			doctor[itr] = new Doctor();
		}
		
		doctor[0].setRegNo("APVSKP01");
		doctor[0].setDocName("Srinivas");
		
		doctor[1].setRegNo("APVSKP02");
		doctor[1].setDocName("Sudheer");
		
		doctor[2].setRegNo("APVSKP03");
		doctor[2].setDocName("Praveen");
		
		return doctor;
	}
	
}
