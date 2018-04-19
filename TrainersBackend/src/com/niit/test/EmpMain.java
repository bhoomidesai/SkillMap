package com.niit.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.reposiitory.EmployeeRepository;

public class EmpMain 
{
	 
public static void main(String[] args) throws Exception {
		
		EmployeeRepository emp=new EmployeeRepository();
		//emp.insertRecords();
		//emp.update();
		emp.delete();
		
			     
				    
		
	}

}
