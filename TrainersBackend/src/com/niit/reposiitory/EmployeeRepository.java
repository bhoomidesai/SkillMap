package com.niit.reposiitory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.config.Utility;

public class EmployeeRepository {
	public boolean insertRecords() throws ClassNotFoundException, SQLException, IOException, ParseException {
		Utility emp = new Utility();

		Connection con = emp.createConnection();
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		// accept data
		System.out.println("Enter Employee code : ");
		int eid = sc.nextInt();
		ps.setInt(1, eid);
		boolean flag = false;
		do {
			System.out.println("Enter email : ");
			String email = sc.next();
			
			if (validateEmailAddress(email)) {
				ps.setString(2, email);
				flag = true;
			} else {
				System.out.println("Invalid Email Id");
			}
		} while (!flag);

		System.out.println("Enter name : ");
		String name = sc.next();
		ps.setString(3, name);

		System.out.println("Enter qualification : ");
		String qualification = sc.next();
		ps.setString(4, qualification);

		java.sql.Date emp_DOJ = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ps.setDate(5, emp_DOJ);

		System.out.println("Enter Business unit : ");
		String bu = sc.next();
		ps.setString(6, bu);

		System.out.println("Enter designation : ");
		String designation = sc.next();
		ps.setString(7, designation);

		System.out.println("Enter address : ");
		String address = sc.next();
		ps.setString(8, address);

		System.out.println("Enter password : ");
		String password = sc.next();
		ps.setString(9, password);

		do {
			flag=false;
			System.out.println("Enter contact no. : ");
			String contact = sc.next();

			if (validatecontact(contact)) {
				ps.setString(10, contact);
				flag = true;
			} else {
				System.out.println("Invalid contact no.");
			}
		} while (!flag);

		System.out.println("Enter centre code : ");
		int cCode = sc.nextInt();
		ps.setInt(11, cCode);

		System.out.println("Enter rating : ");
		int rating = sc.nextInt();
		ps.setInt(12, rating);

		System.out.println("Enter total student tought : ");
		int nos = sc.nextInt();
		ps.setInt(13, nos);

		System.out.println("Enter total hours tought : ");
		int noh = sc.nextInt();
		ps.setInt(14, noh);

		System.out.println("Enter placement % : ");
		float plc = sc.nextFloat();
		ps.setFloat(15, plc);

		System.out.println("Enter skills : ");
		String skills = sc.next();
		ps.setString(16, skills);

		System.out.println("Enter placement companies : ");
		String comp = sc.next();
		ps.setString(17, comp);

		System.out.println("Enter certification : ");
		String certification = sc.next();
		ps.setString(18, certification);

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

	private static Pattern emailNamePtrn = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static Pattern contactptrn = Pattern.compile("^[0-9]{10}$");

	public static boolean validateEmailAddress(String email) {
		Matcher mtch = emailNamePtrn.matcher(email);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validatecontact(String cno) {

		Matcher mtch = contactptrn.matcher(cno);
		if (mtch.matches()) {
			System.out.println("matches");
			return true;
		}
		System.out.println("not matches");
		return false;
	}

	public boolean update() throws Exception {
		System.out.println("Enter Employee id to be updated : ");
		Scanner sc = new Scanner(System.in);
		int eid = sc.nextInt();
		Utility emp = new Utility();

		Connection con = emp.createConnection();
		
		PreparedStatement ps = con.prepareStatement("update Employee set 	"
				+ "EMPLOYEE_EMAIL =?, 	EMPLOYEE_NAME  =?, 	QUALIFICATION  =?, 	EMPLOYEE_DOJ  =?, 	"
				+ "BUSINESS_UNIT   =?,	DESIGNATION   =?,	ADDRESS   =?,	PASSWORD  =?, 	CONTACT_NO   =?,	"
				+ "CENTRE_CODE   =?,	RATING   =?,	TOTAL_STUDENT_TOUGHT   =?,	TOTAL_HOURS_TOUGHT   =?,	"
				+ "PLACEMENT_PER  =?, 	SKILLS   =?,	PLACEMENT_COMPANIES  =?, 	CERTIFICATIONS =? where employee_id = ?  ");
		// accept data
		boolean flag = false;
		do {
			System.out.println("Enter email : ");
			String email = sc.next();
			
			if (validateEmailAddress(email)) {
				ps.setString(1, email);
				flag = true;
			} else {
				System.out.println("Invalid Email Id");
			}
		} while (!flag);

		System.out.println("Enter name : ");
		String name = sc.next();
		ps.setString(2, name);

		System.out.println("Enter qualification : ");
		String qualification = sc.next();
		ps.setString(3, qualification);

		java.sql.Date emp_DOJ = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ps.setDate(4, emp_DOJ);

		System.out.println("Enter Business unit : ");
		String bu = sc.next();
		ps.setString(5, bu);

		System.out.println("Enter designation : ");
		String designation = sc.next();
		ps.setString(6, designation);

		System.out.println("Enter address : ");
		String address = sc.next();
		ps.setString(7, address);

		System.out.println("Enter password : ");
		String password = sc.next();
		ps.setString(8, password);

		do {
			System.out.println("Enter contact no. : ");
			String contact = sc.next();

			if (validatecontact(contact)) {
				ps.setString(9, contact);
				flag = true;
			} else {
				System.out.println("Invalid contact no.");
			}
		} while (!flag);

		System.out.println("Enter centre code : ");
		int cCode = sc.nextInt();
		ps.setInt(10, cCode);

		System.out.println("Enter rating : ");
		int rating = sc.nextInt();
		ps.setInt(11, rating);

		System.out.println("Enter total student tought : ");
		int nos = sc.nextInt();
		ps.setInt(12, nos);

		System.out.println("Enter total hours tought : ");
		int noh = sc.nextInt();
		ps.setInt(13, noh);

		System.out.println("Enter placement % : ");
		float plc = sc.nextFloat();
		ps.setFloat(14, plc);

		System.out.println("Enter skills : ");
		String skills = sc.next();
		ps.setString(15, skills);

		System.out.println("Enter placement companies : ");
		String comp = sc.next();
		ps.setString(16, comp);

		System.out.println("Enter certification : ");
		String certification = sc.next();
		ps.setString(17, certification);
		ps.setInt(18, eid);
		int x = ps.executeUpdate();
		con.close();
		if (x > 0) {
			System.out.println("Row updated");
			return true;
		} else {
			System.out.println("not updated");
			return false;
		}

	}
	public boolean delete() throws Exception
	{
		Utility emp = new Utility();
		Connection con = emp.createConnection();
		System.out.println("Enter Employee id to be deleted : ");
		Scanner sc = new Scanner(System.in);
		int eid = sc.nextInt();
		
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
}
