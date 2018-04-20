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




@WebServlet("/reg")
public class ResisterRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
	       
	        dispatcher.forward(request, response);

	}

}
