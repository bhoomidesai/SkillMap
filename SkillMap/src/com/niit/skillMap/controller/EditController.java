package com.niit.skillMap.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.EmployeeRepository;




@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("id : "+request.getParameter("employee_id"));
	        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
	        Employee employee = new Employee();
	        System.out.println("id : "+request.getParameter("employee_id"));
			try {
				employee = new EmployeeRepository().getById(employeeId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);

	}

}
