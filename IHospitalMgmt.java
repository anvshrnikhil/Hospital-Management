package com;

public interface IHospitalMgmt {
	int registerDoctor(Doctor d);
	int hospitalizePatient(String s,Patient p);
	int releasePatient(int a);
	Doctor retriveDoctorInfo(int a);
	int patientCountPerCity(String city);
}
