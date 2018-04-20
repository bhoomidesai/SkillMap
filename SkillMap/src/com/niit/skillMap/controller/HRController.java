package com.niit.skillMap.controller;


import java.io.IOException;
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

@WebServlet("/hr")
public class HRController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeRepository repository=new EmployeeRepository();
        List<Employee> list = new ArrayList<Employee>();
		try {System.out.println("in try");
			list = repository.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("employeeList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/approve.jsp");
	       
	        dispatcher.forward(request, response);

	}

}

