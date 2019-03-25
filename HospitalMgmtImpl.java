package com;

import java.util.ArrayList;
import java.util.List;

public class HospitalMgmtImpl implements IHospitalMgmt {
	List<Doctor> doctorList;
	public HospitalMgmtImpl()
	{
		doctorList=new ArrayList<Doctor >();
	}
	public int registerDoctor(Doctor d)
	{
		if(doctorList.size()==0)
		{
			doctorList.add(d);
			return doctorList.size();
		}
		
		else{
			Doctor doc[]=doctorList.toArray(new Doctor[doctorList.size()]);
		try
		{
			for(int i=0;i<doc.length;i++)
			{
				if(doc[i].getRegNo().compareTo(d.getRegNo())==0)
				{
					i=doc.length;
					throw new DuplicateDoctorException();
				}
			}
			doctorList.add(d);
		

			return doctorList.size();

		}
		catch(DuplicateDoctorException e)
		{
			System.out.println("Exception:"+e);
			return -1;
		}
		}
		
	}
	public int hospitalizePatient(String regNo,Patient p)
	{
		Doctor doc[]=doctorList.toArray(new Doctor[doctorList.size()]);
		try{
			for(int i=0;i<doc.length;i++)
			{
				if(doc[i].getRegNo().compareTo(regNo)==0)
				{
					if(doc[i].patientList.contains(p.getUld()))
					{
						i=doc.length;
						throw new PatientExitException();
					}
					else
					{
						doctorList.get(i).patientList.add(p);
						int getsi=doctorList.get(i).patientList.size();
						i=doc.length;
						return getsi;
					}
				}
			}
			return -1;
		}
		catch(PatientExitException e)
		{
			System.out.println("Exception :"+e);
			return -1;
		}
	}
	public int releasePatient(int a)
	{
		Doctor doc[]=doctorList.toArray(new Doctor[doctorList.size()]);
		
		for(int i=0;i<doc.length;i++)
		{
			Patient pat[]=doc[i].patientList.toArray(new Patient[doc[i].patientList.size()]);
			for(int j=0;j<pat.length;j++)
			{
				if(pat[i].getPatientID()==a)
				{
					doctorList.get(i).patientList.remove(j);
					return doctorList.get(i).patientList.size();
				}
			}
		}
		return -1;
	}
	public Doctor retriveDoctorInfo(int patid)
	{
		Doctor doc[]=doctorList.toArray(new Doctor[doctorList.size()]);
		for(int i=0;i<doc.length;i++)
		{
			Patient pat[]=doc[i].patientList.toArray(new Patient[doc[i].patientList.size()]);
			for(int j=0;j<pat.length;j++)
			{
				if(pat[j].getPatientID()==patid)
					return doc[i];
			}
		}
		return null;
		
	}
	public int patientCountPerCity(String city)
	{
		int count=0;
		Doctor doc[]=doctorList.toArray(new Doctor[doctorList.size()]);
		for(int i=0;i<doc.length;i++)
		{
			Patient pat[]=doc[i].patientList.toArray(new Patient[doc[i].patientList.size()]);
			for(int j=0;j<pat.length;j++)
			{
				if(pat[j].getCity().compareTo(city)==0)
					count++;
			}
		}
		return count;
	}

}
