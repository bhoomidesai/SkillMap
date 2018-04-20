package com.niit.skillMap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeeEmail=request.getParameter("email");
		String employeePhone=request.getParameter("phone");
		String employeeCity=request.getParameter("city");
		String employeePassword=request.getParameter("password");
		
		Employee employee=new Employee();
		employee.setEmployee_id(employeeId);
		employee.setEmployee_name(employeeName);
		employee.setEmployee_email(employeeEmail);
		employee.setContact_no(employeePhone);
		employee.setAddress(employeeCity);
		employee.setPassword(employeePassword);
		employee.setStatus(false);
		
		EmployeeRepository repository=new EmployeeRepository();
		boolean status=false;
		try {
			status = repository.insertRecords(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			response.getWriter().println("Successfully registered Try to login");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.include(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		requestDispatcher.include(request, response);
	}

}
