package com.niit.skillMap.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;

import com.niit.skillMap.config.Utility;





public class EmployeeRepository 
{
	Connection con = null;
	Utility utility = null;
	
	Statement st = null;
	public EmployeeRepository() {
		utility=new Utility();
		con = utility.createConnection();
	}
	
	PreparedStatement ps=null;
	public boolean insertRecords(Employee employee) throws ClassNotFoundException, SQLException, IOException, ParseException 
	{
		con = utility.createConnection();
		ps = con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		// accept data
		ps.setInt(1, employee.getEmployee_id());
		ps.setString(2, employee.getEmployee_email());		
		ps.setString(3, employee.getEmployee_name());
		ps.setString(4, employee.getQualification());

		java.sql.Date emp_DOJ = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ps.setDate(5,emp_DOJ );
		ps.setString(6,employee.getBusiness_unit());
		ps.setString(7, employee.getDesignation());
		ps.setString(8, employee.getAddress());
		ps.setString(9, employee.getPassword());
		ps.setString(10, employee.getContact_no());		
		ps.setInt(11, employee.getCentre_Code());
		ps.setInt(12, employee.getRating());
		ps.setInt(13, employee.getTotal_student_tought());
		ps.setInt(14, employee.getTotal_hours_tought());
		ps.setFloat(15, employee.getPlacement_per());
		ps.setString(16, employee.getSkills());
		ps.setString(17, employee.getPlacement_companies());
		ps.setString(18, employee.getCertifications());

		int x = ps.executeUpdate();
		con.close();
		if (x > 0) {
			System.out.println("Row inserted");
			return true;
		} else {
			System.out.println("not inserted");
			return false;
		}

	}


	public boolean update(Employee employee,int eid) throws Exception 
	{
		
		PreparedStatement ps = con.prepareStatement("update Employee set 	"
				+ "EMPLOYEE_EMAIL =?, 	EMPLOYEE_NAME  =?, 	QUALIFICATION  =?, 	EMPLOYEE_DOJ  =?, 	"
				+ "BUSINESS_UNIT   =?,	DESIGNATION   =?,	ADDRESS   =?,	PASSWORD  =?, 	CONTACT_NO   =?,	"
				+ "CENTRE_CODE   =?,	RATING   =?,	TOTAL_STUDENT_TOUGHT   =?,	TOTAL_HOURS_TOUGHT   =?,	"
				+ "PLACEMENT_PER  =?, 	SKILLS   =?,	PLACEMENT_COMPANIES  =?, 	CERTIFICATIONS =? where employee_id = ?  ");
		// accept data
		ps.setString(1, employee.getEmployee_email());		
		ps.setString(2, employee.getEmployee_name());
		ps.setString(3, employee.getQualification());

		java.sql.Date emp_DOJ = new java.sql.Date(employee.getEmployee_DOJ().getDate());
		ps.setDate(4,emp_DOJ );
		ps.setString(5,employee.getBusiness_unit());
		ps.setString(6, employee.getDesignation());
		ps.setString(7, employee.getAddress());
		ps.setString(8, employee.getPassword());
		ps.setString(9, employee.getContact_no());		
		ps.setInt(10, employee.getCentre_Code());
		ps.setInt(11, employee.getRating());
		ps.setInt(12, employee.getTotal_student_tought());
		ps.setInt(13, employee.getTotal_hours_tought());
		ps.setFloat(14, employee.getPlacement_per());
		ps.setString(15, employee.getSkills());
		ps.setString(16, employee.getPlacement_companies());
		ps.setString(17, employee.getCertifications());
		ps.setInt(18, eid);

		int x = ps.executeUpdate();
		con.close();
		if (x > 0) {
			System.out.println("Row inserted");
			return true;
		} else {
			System.out.println("not inserted");
			return false;
		}

	}
	public boolean delete(int eid) throws Exception
	{
		PreparedStatement ps = con.prepareStatement("delete from employee where employee_id = ?  ");
		ps.setInt(1, eid);
		int x = ps.executeUpdate();
		con.close();
		if (x > 0) {
			System.out.println("Row deleted");
			return true;
		} else {
			System.out.println("not deleted");
			return false;
		}
	}
	public Employee getById(int eid) throws Exception
	{
		Employee employee;
		PreparedStatement ps = con.prepareStatement("Select * from employee where employee_id = ?  ");
		ps.setInt(1, eid);
		employee = (Employee) ps.executeQuery();
		return employee;
		
	}
	public Employee getByEmail(String email)
	{
		Employee employee = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("Select * from employee where employee_email = ?  ");
			ps.setString(1, email);
			employee = (Employee) ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
		
	}
	public int validateEmployee (String eid,String password)
	{
		Employee employee;
		int count=0;
		try {System.out.println("--->"+Integer.parseInt(eid));
			st = con.createStatement();
			
			
			
			ResultSet resultSet=ps.executeQuery("select * from employee where employee_id="+Integer.parseInt(eid)+" and password='"+password+"'");
			while(resultSet.next())
				count++;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return count;
	}
	
	public ResultSet getAll() throws Exception
	{
		PreparedStatement ps = con.prepareStatement("Select * from employee");
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}