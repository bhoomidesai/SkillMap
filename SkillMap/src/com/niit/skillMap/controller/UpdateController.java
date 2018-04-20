package com.niit.skillMap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.EmployeeRepository;


@WebServlet("/updateProfile")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeePhone=request.getParameter("phone");
		String employeeEmail=request.getParameter("email");
		String employeeCity=request.getParameter("city");
		String employeeQualification=request.getParameter("qualification");
		String employeeSkill=request.getParameter("skill");
		String employeeCertification=request.getParameter("certification");
		String business_unit=request.getParameter("bu");
		int centreCode=Integer.parseInt(request.getParameter("centercode"));
		String designation = request.getParameter("role");
		String plComp = request.getParameter("plcomp");
		System.out.println("role : "+designation);
		int per = Integer.parseInt(request.getParameter("per"));
		int rate =  Integer.parseInt(request.getParameter("rate"));
		int total_hour_tought=Integer.parseInt(request.getParameter("tht"));
		int total_student_tought=Integer.parseInt(request.getParameter("tst"));
	
		
		java.util.Date date=new java.util.Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doj"));
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    java.sql.Date doj = new java.sql.Date(date.getTime());
		
		Employee employee=new Employee();
		employee.setEmployee_id(employeeId);
		employee.setEmployee_name(employeeName);
		employee.setEmployee_email(employeeEmail);
		employee.setContact_no(employeePhone);
		employee.setAddress(employeeCity);
		employee.setQualification(employeeQualification);
		employee.setSkills(employeeSkill);
		employee.setCertifications(employeeCertification);
		employee.setCentre_Code(centreCode);
		employee.setDesignation(designation);
		employee.setEmployee_DOJ(doj);
		employee.setBusiness_unit("CEB");
		employee.setPlacement_companies(plComp);
		employee.setPlacement_per(per);
		employee.setRating(rate);
		employee.setTotal_hours_tought(total_hour_tought);
		employee.setCentre_Code(centreCode);
		employee.setTotal_student_tought(total_student_tought);

		
		EmployeeRepository repository=new EmployeeRepository();
		boolean status=true;
		try {
			status = repository.update(employee, employeeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);
			
		}
	}

}
