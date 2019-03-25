package com;

public class IDGenerator {
	private int id;
	public IDGenerator()
	{
		id=0;
	}
	public int getID()
	{
		return ++id;
	}
}
