package com.niit.test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import com.niit.reposiitory.EmployeeRepository;

public class EmployeeTest 
{
	EmployeeRepository emp=new EmployeeRepository();
	
	@Test
	public void insertTest() throws ClassNotFoundException, SQLException, IOException, ParseException
	{
		assertEquals("Success", true, emp.insertRecords());
		
	}
	
	@Test
	public void nInsertTest() throws ClassNotFoundException, SQLException, IOException, ParseException
	{
		assertNotEquals("Failed", 20, emp.insertRecords());
	}
	@Test
	public void updateTest() throws Exception
	{
		assertEquals("Success", true, emp.update());
		
	}
	
	@Test
	public void nUpdateTest() throws Exception
	{
		assertNotEquals("Failed", 20, emp.update());
	}

	

}
