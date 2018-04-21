/*package com.niit.skillMap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.EmployeeRepository;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterController() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<String> errorList=new ArrayList<>();
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeeEmail=request.getParameter("email");
		String employeePhone=request.getParameter("phone");
		String employeeCity=request.getParameter("city");
		String employeePassword=request.getParameter("password");
		String role = request.getParameter("role");
		
		Employee employee=new Employee();
		employee.setEmployee_id(employeeId);
		employee.setEmployee_name(employeeName);
		employee.setEmployee_email(employeeEmail);
		employee.setContact_no(employeePhone);
		employee.setAddress(employeeCity);
		employee.setPassword(employeePassword);
		employee.setDesignation(role);
		employee.setStatus(false);
		errorList=employee.getMap();
		EmployeeRepository repository=new EmployeeRepository();
		boolean status=false;
		try {
			if(errorList.size()==0)
			{
			status = repository.insertRecords(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			request.setAttribute("invalid", "Successfully registered Try to login");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/reg");
			requestDispatcher.include(request, response);
		}
		else
		{
			request.setAttribute("error", errorList);
			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/reg");
			requestDispatcher.forward(request, response);
		}
	}
	
	
	
	}


*/