package com.niit.skillMap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.EmployeeRepository;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		String employeePassword=request.getParameter("password");
		
		EmployeeRepository repository = new EmployeeRepository();
		int count = repository.validateEmployee(eid,employeePassword);
		if(count>0)
		{
			Employee employee = new Employee();
			try {
				employee = repository.getById(eid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("employee", employee);
			System.out.println("ename : "+employee.getEmployee_name());
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			out.println("Wrong Username or Password try to login again");
			request.setAttribute("invalid", "Wrong Username or Password try to login again");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			requestDispatcher.forward(request, response);
		}
			
		
	}

}
